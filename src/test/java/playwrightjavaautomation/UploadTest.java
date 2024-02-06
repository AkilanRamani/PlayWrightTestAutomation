package playwrightjavaautomation;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

public class UploadTest {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://www.sendgb.com/");
			
			page.locator("button:has-text('Close') >> visible=true").click();
			page.locator("span:has-text('OK') >> visible=true").click();


				page.locator("input[type='file']").setInputFiles(new Path[] {
					Paths.get("sample.xlsx"),
					Paths.get("sec.xlsx")
			});
    // Charset char1 =   StandardCharsets.UTF_8;
		page.navigate("https://the-internet.herokuapp.com/upload");
		FileChooser fileChooser = page.waitForFileChooser(()->{
			page.locator("id=drag-drop-upload").click();			
		});
		System.out.println(fileChooser.isMultiple());
		if(fileChooser.isMultiple()) {
			fileChooser.setFiles(new Path[] {
					Paths.get("sample.xlsx"),
					Paths.get("sec.xlsx")
			});

		}
		else System.out.println("only one");
		
		Locator searchLocator = page.getByPlaceholder("Search");
		searchLocator.click();
		searchLocator.screenshot(new Locator.ScreenshotOptions()
			.setPath(Paths.get("./snaps/hide.png"))
			.setCaret(ScreenshotCaret.HIDE)
			.setMask(Arrays.asList(searchLocator)));

	}

	}



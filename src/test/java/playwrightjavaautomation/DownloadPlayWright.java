package playwrightjavaautomation;

import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadPlayWright {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		BrowserType page1 = playwright.chromium();
	
		page.navigate("https://letcode.in/file");
 	    Locator p =   page.locator("Test");
 	    
		Download download = page.waitForDownload(()->{			
			page.locator("'Download Excel'").click();
		});
		System.out.println(download.path());
		System.out.println(download.url());
		System.out.println(download.failure());
		System.out.println(download.suggestedFilename());
		download.saveAs(Paths.get(download.suggestedFilename()));
		
		
		
		playwright.close();
		
		
	}


	}



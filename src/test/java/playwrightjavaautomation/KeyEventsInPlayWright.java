package playwrightjavaautomation;

import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class KeyEventsInPlayWright {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://keycode.info");
		page.keyboard().press("A");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("A.png")));
		page.keyboard().press("ArrowLeft");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("ArrowLeft.png")));
		page.keyboard().press("Shift+O");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("O.png")));
		
	}

}

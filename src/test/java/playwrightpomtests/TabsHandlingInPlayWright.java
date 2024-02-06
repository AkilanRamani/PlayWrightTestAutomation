package playwrightpomtests;

import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class TabsHandlingInPlayWright {
	
	@Test
	public void testWindowFrames() {
	
	Playwright playwright = Playwright.create();
	LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
	Page page = playwright.chromium().launch(headless).newPage();
	page.navigate("https://demo.automationtesting.in/Windows.html");
	System.out.println(page.title());
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    page.click("text=Open New Seperate Windows");
    System.out.println(page.title());
}
}
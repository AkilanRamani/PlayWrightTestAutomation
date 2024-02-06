package playwrightjavaautomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class TestHTTPAuth {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		//LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
		//Page page = playwright.chromium().launch(options).newPage();
		BrowserContext context =  browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin","admin"));
	   Page page =  context.newPage();
	   page.navigate("https://the-internet.herokuapp.com/basic_auth");
	  page.close();
	  
	

}
}
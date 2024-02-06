package playwrightjavaautomation;


import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		String url = "https://playwright.dev/java/docs/actionability";
		Playwright playwright = Playwright.create();
		Browser typebros = playwright.chromium().launch();
	    Browser browser1 =   playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
	    BrowserContext browserContext=browser1.newContext();
		Page page= browserContext.newPage();
		browserContext.tracing().start(new Tracing.StartOptions()
				  .setScreenshots(true)
				  .setSnapshots(true)
				  .setSources(true));
		page.navigate(url);
		page.waitForURL(url);
		browserContext.tracing().stop(new Tracing.StopOptions()
				  .setPath(Paths.get("trace.zip")));
		//page.type("//textarea[@name='q']", "BMW 7 Series");
		//page.keyboard().press("Enter");
	//	page.context().browser().close();   
		Locator loc = page.locator("//a");
	    System.out.println(loc.allTextContents());
	    
	   byte[] b = page.screenshot(new Page.ScreenshotOptions()
	    		  .setPath(Paths.get("screenshot.png"))
	    		  .setFullPage(true));
	   Base64.getEncoder().encodeToString(b);
		
		
		
		
	        }
	    }

	



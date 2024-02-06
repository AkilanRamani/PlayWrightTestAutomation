package playwrightjavaautomation;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.BrowserChannel;

public class TestScriptAutomation {
	
	Locator locator;
	
	
	public static void main(String[] args) {
		
		String url = "https://www.amazon.in/";
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
		page.pause();
		System.out.println(page.locator("button:visible").textContent());
		browserContext.tracing().stop(new Tracing.StopOptions()
				  .setPath(Paths.get("trace.zip")));
		browserContext.close();
		page.close();
	}}

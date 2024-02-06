package playwrighttestautomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightConnection {
	
	protected Driver createConnection() throws Exception {
		try {
			Playwright playwright = Playwright.create();
			BrowserType browserType = playwright.chromium();
	    
			LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
			Browser browser = browserType.launch(headless);
		    Page page =	browser.newPage();
			return new Driver(playwright, browser,page);
			
		}
		catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	protected void closeConnection(Driver driver){
		driver.getPage().close();
		driver.getBrowser().close();
		driver.getPlaywright().close();
	}

	protected void setTestStatus(String status, String remark,Page page) {
		//page.evaluate("() => {}", "lambdatest_action: { \"action\": \"setTestStatus\", \"arguments\": { \"status\": \"" + status + "\", \"remark\": \"" + remark + "\"}}");
		page.evaluate("The Given Test Scenario is " + status + "with the" + remark + "in the " + page);
	}

}

package playwrightjavaautomation;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class AlertTestPage {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(options).newPage();
		page.onDialog(a->{
			String defaultValue = a.message();
			System.out.println(defaultValue);
			a.accept("Koushik");	
			a.accept();
			String test = a.type();
		});
		
		

	}

}

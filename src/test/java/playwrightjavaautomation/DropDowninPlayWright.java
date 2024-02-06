package playwrightjavaautomation;


import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.SelectOptionOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import com.microsoft.playwright.options.SelectOption;

public class DropDowninPlayWright {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(options).newPage();
		 page.navigate("https://letcode.in/dropdowns");
		
		Locator locator = page.locator("#fruits");
		Locator locs = locator.locator("option");
	    List<String> list = locs.allInnerTexts();
	    list.forEach(i -> System.out.println(i));
		SelectOption option = new SelectOption();
		SelectOption options1 = option.setIndex(4);
		SelectOptionOptions options2 = new SelectOptionOptions();
		options2.setForce(false);
		
		locator.selectOption(options1 , options2);
	    String textcontent = 	page.locator("p.subtitle").textContent();
	    System.out.println(textcontent);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package playwrightjavaautomation;


import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class FramesTest {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/frame");
		FrameLocator frameLocator = page.frameLocator("#firstFr");
		frameLocator.getByPlaceholder("Enter name").fill("Akilan");
		frameLocator.getByPlaceholder("Enter email").fill("Ramani");
		List<Frame> frames = page.frames();
	    System.out.println(frames.size()); 
		
	
	   Frame frame = page.frame("firstFr");
	   frame.getByPlaceholder("Enter name").fill("Akshaya");
	   frame.getByPlaceholder("Enter email").fill("Ramani");
	
	   List<Frame> childFrames = frame.childFrames();
	   System.out.println(childFrames.size());
	   childFrames.forEach(f->{
	   System.out.println(f.url());
	});
	   Frame innerFrame = page.frameByUrl("https://letcode.in/innerFrame");
	//Frame innerFrame1 = page.frameByUrl(Pattern.compile("innerFrame"));
		innerFrame.getByPlaceholder("Enter email").fill("aki@gmail.com");
	   frame.getByPlaceholder("Enter email").fill("letcode");
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		playwright.close();
	}
}

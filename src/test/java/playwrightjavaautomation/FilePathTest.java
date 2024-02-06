package playwrightjavaautomation;

import java.io.File;

public class FilePathTest {

	public static void main(String[] args) {
		
		
		 File obj = new File("C:\\Users\\akilan-18633\\Desktop\\abc.txt");
         if(obj.exists()) {
        	 
        	 System.out.println("The File Exists");
         }
         else {
        	 
        	 System.out.println("The 1- File Exists");
         }
	}
	
}
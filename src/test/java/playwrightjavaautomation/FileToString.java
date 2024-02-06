package playwrightjavaautomation;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileToString {

	public static void main(String[] args) {
	     Path path 
	     = Paths.get("C:\\Users\\akilan-18633\\Desktop\\TextFile.txt"); 
	      
	            // call toFile() to get 
	            // File object from path 
	            File file = path.toFile(); 
	      
	            // print file details 
	            System.out.println("File:" + file.toString() 
	                               + " is readable "
	                               + file.canRead()); 
	        } 

	}



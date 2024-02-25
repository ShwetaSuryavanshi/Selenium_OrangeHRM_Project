package testng5_screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _1Screenshots {
	WebDriver driver;
	@BeforeTest
	@Parameters("url")
	public void setup(String url) throws IOException {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver= new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		this.takesnapshot(driver, "D:\\Devops\\Screenshot_selenium.png") ; 
		}
	@Test
	public static void takesnapshot(WebDriver webdriver,String fileWithPath) throws IOException {
		 //Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot= (TakesScreenshot) webdriver;
		 //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

    //Move image file to new destination
        

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
	}
	
}

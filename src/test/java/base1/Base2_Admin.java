package base1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base2_Admin {
	
public static WebDriver driver;
	
	public static	FileReader fr;
	public static Properties pr= new Properties();
	
	@BeforeTest
	public void setup() throws IOException {
		if(driver==null) {
			fr= new FileReader("D:\\Devops\\TestNG_Updated2\\OrangeHRM_Project\\src\\test\\resources\\configuration\\config.properties");
		pr.load(fr);
		}
		
		if(pr.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get(pr.getProperty("test_url"));
			
		}
		else if (pr.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.get(pr.getProperty("test_url"));
		}
	}
//	@AfterTest
//	public void teardown() {
//		driver.quit();
//	}
}



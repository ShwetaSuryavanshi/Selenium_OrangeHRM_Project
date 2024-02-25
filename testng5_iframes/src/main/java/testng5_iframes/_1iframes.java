package testng5_iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _1iframes {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver= new FirefoxDriver();
		
		driver.get("https://chercher.tech/practice/frames");
		driver.manage().window().maximize();
		}
	
	@Test
	public void test1() {
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Shweta");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		
		driver.switchTo().parentFrame();
		
		
				
	}

}


package testng3_switchtab;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Switchtabs {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
 
	System.setProperty("webdriver.http.factory","jdk-http-client");
	driver= new FirefoxDriver();
	driver.get("https://www.myntra.com/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	}
	
	@Test(priority=1)
	private void Test1() {
		
		driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Men']")).click();
		
		WebElement ele=driver.findElement(By.xpath("//div[@class='carousel-base']"));
		Actions action= new Actions(driver);
		action.moveToElement(ele).build().perform();
		
       driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("tshirts");
       WebDriverWait explicit= new WebDriverWait(driver, Duration.ofSeconds(30));
       explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Tshirts Girls']")));
       
       WebElement ele2=driver.findElement(By.xpath("//li[text()='Tshirts Girls']"));
      Actions action2= new Actions(driver);
      action2.moveToElement(ele2).build().perform();
      driver.findElement(By.xpath("//li[text()='Tshirts Girls']")).click();
      
      
	}
	@Test(priority=2, dependsOnMethods="Test1")
	private void Test2() {
		WebDriverWait explicit= new WebDriverWait(driver, Duration.ofSeconds(30));
	       explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='KiddoPanti Kids High Neck Cotton T-shirt']")));
	       
		driver.findElement(By.xpath("//img[@title='KiddoPanti Kids High Neck Cotton T-shirt']")).click();
		Set<String> handle= driver.getWindowHandles();
		Iterator<String> it= handle.iterator();
		String ParentWindow= it.next();		
	System.out.println("parent widow is"+ ParentWindow);	
	String title= driver.getTitle();
	System.out.println("Title is: "+ title);
	
	String ChildWindow= it.next();		
	System.out.println("Child widow is"+ ChildWindow);
	driver.switchTo().window(ChildWindow);
	String title1= driver.getTitle();
	System.out.println("Title1 is: "+ title1);
	}
	
	
	@Test(priority=3)
	public void teardown() {
		driver.quit();
	}
}

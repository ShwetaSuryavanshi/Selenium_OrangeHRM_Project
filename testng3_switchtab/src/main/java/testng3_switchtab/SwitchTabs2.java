package testng3_switchtab;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;



public class SwitchTabs2{
	WebDriver driver;
	
	@Test(priority=1)
	public void setup() {
		 
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new FirefoxDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		}
	
	@Test(priority=2)
	
	
	public void scrolldown()  {
	WebDriverWait Explicit = new WebDriverWait(driver, Duration.ofSeconds(30));
	Explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='Header1_headerimg']")));
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
	}
		
	@Test(priority=3, dependsOnMethods="scrolldown")
		public void openwindow() {
		driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
		
		Set<String> handle= driver.getWindowHandles();
		
		Iterator<String> it= handle.iterator();
		System.out.println(handle.size());
		 String title= driver.getTitle();
		String parentwindow=it.next();
		System.out.println("Parent window is: "+ parentwindow);
		System.out.println("ParentTitle: "+ title);
		
		String child1window=it.next();
		System.out.println("child1window is: "+ child1window);
		driver.switchTo().window(child1window);
		driver.manage().window().maximize();
		WebDriverWait Explicit2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		Explicit2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Basic Controls in HTML']")));
		
		System.out.println("child1windowTitle: "+ driver.getTitle());
		
		
//		opentab(parentwindow,title);
//	}
//	
//	@Test(priority=3)
//	public void opentab(String parentwindow, String title) throws InterruptedException {
//		Thread.sleep(2000);
		
		driver.switchTo().window(parentwindow);
		
		System.out.println("Parent window is: "+ parentwindow);
		System.out.println("ParentTitle: "+ title);
		
		driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();

		//		Thread.sleep(2000);
//		String Child2Window= it.next();
//		driver.switchTo().window(Child2Window);
//		//String title3=driver.getTitle();
//		//System.out.println("Child2Window: "+ title3);
//		
//		
//driver.switchTo().window(parentwindow);
//		
//		System.out.println("Parent window is: "+ parentwindow);
//		System.out.println("ParentTitle: "+ title);
	}
	
	@Test(priority=4)
	public void teardown() {
		driver.quit();
	}

}

package testng3_switchtab;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SwitchTabs_MultipleTabs {

WebDriver driver;
	
	@Test(priority=1)
	public void BrowsersetupAndScrollDown_multipletabs() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver=new FirefoxDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebDriverWait Explicit = new WebDriverWait(driver, Duration.ofSeconds(30));
		Explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='Header1_headerimg']")));
			JavascriptExecutor jse= (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,1000)");
		}
	
	
	@Test(priority=2)
	public void multipletabs() {
		driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
		
		Set<String> handle= driver.getWindowHandles();
		Iterator<String> it= handle.iterator();
		System.out.println("No of windows: "+ handle.size());
		
		String parentwindow= it.next();
		String parent_title=driver.getTitle();
		System.out.println("parent_title: "+ parent_title);
		System.out.println("Parent window is: "+ parentwindow);
		
		String child_window1= it.next();
		driver.switchTo().window(child_window1);
		driver.manage().window().maximize();
		WebDriverWait Explicit2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		Explicit2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='post-title entry-title']")));
		
		String child_title1=driver.getTitle();
		System.out.println("child_title1: "+ child_title1);
		System.out.println("child window 1 is: "+ child_window1);
		
		
		
		String child_window2=it.next();
		driver.switchTo().window(child_window2);
		driver.manage().window().maximize();
		WebDriverWait Explicit3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		Explicit3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='post-title entry-title']")));
		
		String child_title2=driver.getTitle();
		System.out.println("child_title2: "+ child_title2);
		System.out.println("child window 2 is: "+ child_window2);
		
		
		
		
		
		
		
	}
	
}

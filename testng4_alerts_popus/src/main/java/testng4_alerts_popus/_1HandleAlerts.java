package testng4_alerts_popus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

public class _1HandleAlerts {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver= new FirefoxDriver();
		
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	public void test1() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='text' and @name='cusid']")).sendKeys("dvfrhjf");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	@Test(priority=2)
public void test2() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='text' and @name='cusid']")).sendKeys("shweta");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath("//input[@type='text' and @name='cusid']"));
		Actions action= new Actions(driver);
		action.keyDown(ele, Keys.CONTROL).sendKeys("a").sendKeys("fgfguyf").build().perform();
		
	}
	
}

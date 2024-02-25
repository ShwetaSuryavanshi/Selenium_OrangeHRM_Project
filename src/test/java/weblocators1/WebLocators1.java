package weblocators1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebLocators1 {
	
	WebDriver driver=null;
	public WebLocators1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@name='username']") WebElement Login_username;
	@FindBy(xpath="//input[@name='password']") WebElement Login_password;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']") WebElement login_button;
	
	
	public void Login_Test(String username, String password) {
		driver.manage().window().maximize();
		Login_username.sendKeys(username);
		Login_password.sendKeys(password);
		login_button.click();
		
	}

	public void explicitwait() {
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(Login_password));
		
	}
	

}

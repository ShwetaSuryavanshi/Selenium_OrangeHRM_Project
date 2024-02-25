package weblocators1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Weblocators_PIM {
	WebDriver driver=null;
	public  Weblocators_PIM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']") WebElement PIM_click;

	public void wait1() {
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(PIM_click));
		
	}
	
	public void navigate_to_PIM() {
		PIM_click.click();
		
	}
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title' and text()='Employee Information']") WebElement EmployeeInformation;
	public void wait2() {
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(EmployeeInformation));
	}
	@FindBy(xpath="//a[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']") WebElement AddEmployee_click;
	public void AddEmployee_click() {
		AddEmployee_click.click();
	}
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Add Employee']") WebElement AddEmployee;
	public void wait3() {
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(AddEmployee));
		
	}
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-firstname' and @name='firstName']") WebElement First_name;
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-middlename' and @name='middleName']") WebElement Middle_name;
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-lastname' and @name='lastName']") WebElement Last_name;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") WebElement employee_id;
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']//child::i[1]") WebElement uploadimage_button;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']") WebElement submit_button;
	public void dataEnter(String Firstname, String Middlename, String Lastname, String EmployeeID) throws InterruptedException, AWTException {
		
		WebDriverWait explicit1= new WebDriverWait(driver,Duration.ofSeconds(60));
		explicit1.until(ExpectedConditions.visibilityOf(AddEmployee));
		
		First_name.sendKeys(Firstname);
		Middle_name.sendKeys(Middlename);
		Last_name.sendKeys(Lastname);
		employee_id.sendKeys(Keys.CONTROL+"a"+EmployeeID);
		WebDriverWait explicit=	new WebDriverWait(driver, Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.elementToBeClickable(uploadimage_button)).click();
		uploadimage_button.click();
		 WebElement frame =driver.switchTo().activeElement();
		  frame.sendKeys("C:\\Users\\Intel\\Pictures\\3.jpg");
		  
		  Thread.sleep(500);

		     Robot robot = new Robot();
		     robot.keyPress(KeyEvent.VK_ESCAPE);
		     robot.keyRelease(KeyEvent.VK_ESCAPE);
		     
		     
		     submit_button.click();
		     
		    // Thread.sleep(300);
		    // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		
		
	}
	
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//child::span[1]") WebElement Webtable_found;
	@FindBy(xpath="//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th']") List<WebElement> Table_header;
	@FindBy(xpath="//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']") List<WebElement> rows;
	@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell']") List<WebElement> each_element;
	public void PIM_webTable(){
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(Webtable_found));
	
		
		int count=0;
		for(WebElement e:Table_header) {
			String value=e.getText();
			System.out.println("Header Values are: "+value);
			count++;
		}
		Assert.assertEquals(count,9,"Header count not matching");
		
		for(WebElement e:rows) {
			String value=e.getText();
		System.out.println("Rows Values are: "+ value);	
		}
		
		for(WebElement e: each_element) {
			String value=e.getText();
			System.out.println("Rows Values are: "+ value);	
		}
		
		
	}
}

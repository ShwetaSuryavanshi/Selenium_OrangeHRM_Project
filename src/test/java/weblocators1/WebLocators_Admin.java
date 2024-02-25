package weblocators1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebLocators_Admin {
	WebDriver driver=null;
	public WebLocators_Admin(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Admin']") WebElement Admin;
	public void explicitwait2() {
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(Admin));
		
	}
	
	public void navigate_toAdmin() {
		Admin.click();
	}
	
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title' and text()='System Users']") WebElement Expwait;
	public void explicitwait3() {
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(Expwait));
		
	}
	
	
@FindBy(xpath="//div[@class='']//input[@class='oxd-input oxd-input--active']") WebElement admin_username;
	@FindBy(xpath="/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i") WebElement User_Role;
	@FindBy(xpath="//div[@class='oxd-select-text-input' and text()='Admin']") WebElement admin_Select_Admin;
	@FindBy(xpath="//button[@type='submit']") WebElement admin_submit;
	@FindBy(xpath="(//div[@role='listbox']//child::div)[3]") WebElement admin_ESS_FromDropDown;
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]") WebElement admin_status;
	@FindBy(xpath="(//div[@role='listbox']//child::div)[2]") WebElement admin_Enabled_FromDropDown;
	public void adminTest_SystemUser() {
		admin_username.sendKeys("John");
		User_Role.click();
		admin_ESS_FromDropDown.click();
		admin_status.click();
		admin_Enabled_FromDropDown.click();
		
				
		admin_submit.click();
		
		//driver.switchTo().alert().dismiss();
		
	}
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']") WebElement admin_add;
	
	public void admin_add() {
		admin_add.click();
		driver.navigate().back();
	}
	
	//Column
	@FindBy(xpath="//div[@role='row']//div[@role='columnheader']") List<WebElement> column_header;
	@FindBy(xpath="//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and text()='Username']") WebElement VisibilityOfColumnName_username;
	
	//Row
	@FindBy(xpath="//div[@class='oxd-table-card']//div[@role='row']") List<WebElement> rows; 
	
	public void getRowAndColumnCounts_webTable() {
		//Get Web table Column counts and it's values
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf( VisibilityOfColumnName_username));
			int Header_Count=0;
		for(WebElement ele: column_header) 
		
		{
			String Value=ele.getText();
			System.out.println("Columns/Header are: "+ Value);
			Header_Count++;
			
		}
		System.out.println("Header_Count are : "+Header_Count);
		Assert.assertEquals(Header_Count, 6,"Header/column Count not matching");
		
		//Get Web table row counts and it's values
		
		int row_count=0;
		for(WebElement ele: rows) {
			String value= ele.getText();
			row_count++;
			System.out.println("Row "+row_count+" is: "+ value);
			
			
		}
		System.out.println("Row counts are: "+row_count);
		
		}
	@FindBy(xpath="(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[1]") WebElement WebTable_ClickCheckBox;
	public void get_WebTable_Elements() {
		//Click Checkbox
		WebTable_ClickCheckBox.click();
		
	}
	
	@FindBy(xpath="//div[@class='oxd-table-body']//div[2]//div[1]//div[6]//div[1]//button[1]//i[1]") WebElement delete_2ndrow;
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']//button[1]") WebElement Cancel_button;
	public void get_WebTable_Elements2() {
	//	WebTable_ClickCheckBox.click();
		delete_2ndrow.click();
		Cancel_button.click();
		
		
		
	}
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']//button[2]") WebElement YesDelete_button;
	
	public void get_WebTable_Elements3() {
		//	WebTable_ClickCheckBox.click();
			delete_2ndrow.click();
			YesDelete_button.click();
			
		}
	@FindBy(xpath="//nav[@class='oxd-topbar-body-nav']//child::li[2]//span") WebElement Job;
	@FindBy(xpath="//a[@class='oxd-topbar-body-nav-tab-link' and text()='Job Categories']") WebElement Job_catogories;
	public void Job() {
		Job.click();
		Actions action = new Actions(driver);
		 action.moveToElement(Job_catogories).build().perform();
		 action.click(Job_catogories).perform();
		
	}
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Add Job Category']") WebElement JobCategory;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']") WebElement Job_add_button;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//child::div[2]//input") WebElement Add_job_name;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']") WebElement click_save;
	public void add_Job(String Job_name) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(JobCategory));
		Job_add_button.click();
		String title= driver.getTitle();
		System.out.println("Job category ADD tite is: "+title);
		
		Add_job_name.sendKeys(Job_name);
		click_save.click();
	}
	
	//Job Category Web Table
	
	@FindBy(xpath="//div[@class='oxd-table-header']//child::div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th' and @role='columnheader']") List<WebElement> job_table_column;
	
	@FindBy(xpath="//div[@class='oxd-table-card']") List<WebElement> job_table_row;
	public void JobCategoryWebTable() {
		WebDriverWait explicit= new WebDriverWait(driver, Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOfAllElements(job_table_column));
		
		int job_column_count=0;
		for(WebElement Job_ele: job_table_column) {
			String Job_Columnvalue=Job_ele.getText();
			System.out.println("Job web table columns are: "+ Job_Columnvalue);
			job_column_count++;
		}
		System.out.println("Job web table columns are: "+ job_column_count);
		//Assert.assertEquals(job_column_count,3,"Job web table Column count not matching");
		
		
		int Job_row_count=0;
		for(WebElement Job_ele: job_table_row) {
			String Job_rowvalue=Job_ele.getText();
			System.out.println("Job web table columns are: "+ Job_rowvalue);
			Job_row_count++;
		}
		System.out.println("Job web table rows are: "+ Job_row_count);
	}

}

package weblocators1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebLocators_Dashboard {
	WebDriver driver=null;
	public WebLocators_Dashboard(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Dashboard']") WebElement Dashboard_click;
	
	public void wait_dashboardTabVisisble() {
		WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(30));
		explicit.until(ExpectedConditions.visibilityOf(Dashboard_click));
	}
	public void NavigateToDashboard() {
		
		Dashboard_click.click();
	}
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']") WebElement Dashboard_visible;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p' and text()='Employee Distribution by Location']") WebElement Employee_Distribution_by_Location_Visible;
public void wait_dashboardVisible() {
	WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(60));
	explicit.until(ExpectedConditions.visibilityOf(Dashboard_visible));
	explicit.until(ExpectedConditions.visibilityOf(Employee_Distribution_by_Location_Visible));
}

@SuppressWarnings("deprecation")
public void screenshot_wholepage() throws IOException {
	
	Date currentdate= new Date();
	String Filename=currentdate.toString().replace(" ", "-").replace(":", "-");
	
	File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File(".//Screenshots//" + Filename + ".png"));
}


}

package testcase1;

import java.io.IOException;

import org.testng.annotations.Test;

import base1.Base2_Admin;
import weblocators1.WebLocators1;
import weblocators1.WebLocators_Dashboard;

public class Testcase4_Dashboard extends Base2_Admin{
	@Test
	public void DashboardTest() throws IOException, InterruptedException {
		WebLocators1 wb= new WebLocators1(driver);
		wb.explicitwait();
		wb.Login_Test("Admin","admin123");
		
		WebLocators_Dashboard wd= new WebLocators_Dashboard(driver);
		wd.wait_dashboardTabVisisble();
		wd.NavigateToDashboard();
		wd.wait_dashboardVisible();
		
		Thread.sleep(300);
		
		wd.screenshot_wholepage();
		
	}

}

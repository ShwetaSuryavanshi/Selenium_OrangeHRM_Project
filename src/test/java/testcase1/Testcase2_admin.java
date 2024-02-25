package testcase1;

import org.testng.annotations.Test;


import base1.Base2_Admin;
import weblocators1.WebLocators1;
import weblocators1.WebLocators_Admin;

public class Testcase2_admin extends Base2_Admin {
	
	@Test(priority=1)
	public void admin_test_page() {
		WebLocators1 wb= new WebLocators1(driver);
		wb.explicitwait();
		wb.Login_Test("Admin","admin123");
	
	
	
	WebLocators_Admin wa= new WebLocators_Admin(driver);
	wa.explicitwait2();
	wa.navigate_toAdmin();
	wa.explicitwait3();
	wa.adminTest_SystemUser();
	wa.admin_add();
	wa.getRowAndColumnCounts_webTable();
	wa.get_WebTable_Elements();
	wa.get_WebTable_Elements2();
	wa.getRowAndColumnCounts_webTable();
	wa.get_WebTable_Elements3();
	wa.getRowAndColumnCounts_webTable();
	//wa.Job();
	//wa.JobCategoryWebTable();
	//wa.add_Job("Doctor");
	//wa.JobCategoryWebTable();
	}
}

package testcase1;

import java.awt.AWTException;

import org.testng.annotations.Test;

import base1.Base2_Admin;
import utilities.ReadExcelData_PIM;
import weblocators1.WebLocators1;
import weblocators1.Weblocators_PIM;
import base1.Base1;
public class testcase3_PIM extends Base1{
@Test(dataProviderClass=ReadExcelData_PIM.class, dataProvider="EmployeeDetailExcellData")
	public void PIM_testpage(String FirstName, String MiddleName, String LastName, String EmployeeID) throws InterruptedException, AWTException {
		WebLocators1 wb= new WebLocators1(driver);
		wb.explicitwait();
		wb.Login_Test("Admin","admin123");
		
		
		Weblocators_PIM wp= new Weblocators_PIM(driver);
		wp.wait1();
		wp.navigate_to_PIM();
		
		wp.wait2();
		wp.AddEmployee_click();
		wp.wait3();
		wp.dataEnter(FirstName, MiddleName,LastName,EmployeeID);
		
		wp.PIM_webTable();
		
		
	}
}

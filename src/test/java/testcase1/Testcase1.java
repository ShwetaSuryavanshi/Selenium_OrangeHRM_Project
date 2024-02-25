package testcase1;

import org.testng.annotations.Test;

import base1.Base1;
import utilities.Readxceldata;
import weblocators1.WebLocators1;

public class Testcase1 extends Base1 {
	
	@Test(dataProviderClass=Readxceldata.class, dataProvider="excelldata", priority=1)
	public void loginTest(String username, String password) {
		
		WebLocators1 wb= new WebLocators1(driver);
		wb.explicitwait();
		wb.Login_Test(username,password);
		
		
	}
	


}

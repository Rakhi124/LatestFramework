/**
 * 
 */
package com.keka.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.keka.base.BaseClass;
import com.keka.dataprovider.DataProviders;
import com.keka.pageobjects.HomePage;
import com.keka.pageobjects.LoginPage;
import com.keka.pageobjects.MyFinancePage;
import com.keka.pageobjects.OrgPage;
import com.keka.utility.Log;
import com.keka.utility.MyScreenRecorder;

/**
 * @author Techversant
 *
 */
public class OrgPageTest extends BaseClass{
	private LoginPage loginPage;
	private HomePage homePage;
	private OrgPage orgpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup( String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Sanity","Regression"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void  validateEmployeeDirectoryPage( String uname, String pswd) throws Throwable {
		
		MyScreenRecorder.startRecording("validateEmployeeDirectoryPage");
		Log.startTestCase("EmployeeDirectoryPageTest");
		loginPage = new LoginPage();
		loginPage.login(uname, pswd, homePage);
	  //  homePage=new HomePage();
	    orgpage=new OrgPage();
	    orgpage.validateEmployeeDirectoryPage();
	    orgpage.validateClaerFilter();
	 /*   String Act=orgpage.getXpathClearFilterVerification();
		String Exp = "Please select any department or location.";
		Log.info("Verifying if user is able to clear filter");
		Assert.assertEquals(Act, Exp);
		Log.info(" Sucess");*/
	    Thread.sleep(1000);
	    MyScreenRecorder.stopRecording();
 }
	
}

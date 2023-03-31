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
import com.keka.utility.Log;

/**
 * @author Techversant
 *
 */
public class MyFinancePageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private MyFinancePage myfinancepage;
	
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
	public void  validateSummaryPage( String uname, String pswd) throws Throwable {
		Log.startTestCase("SummaryPageTest");
		loginPage = new LoginPage();
		loginPage.login(uname, pswd, homePage);
	  //  homePage=new HomePage();
	    myfinancepage=new MyFinancePage();
	    myfinancepage.validateSummaryPage();
		String result=myfinancepage.validateSummaryPage();
		String Exp = "PAN Information";
		Assert.assertEquals(result, Exp);
		System.out.println("Summary Page Verified");
		Log.endTestCase("SummaryPageTest");
		
		//myfinancepage=new MyFinancePage();
		myfinancepage.validateManageTaxPage();
		myfinancepage.validateListClick();
		
	}

}

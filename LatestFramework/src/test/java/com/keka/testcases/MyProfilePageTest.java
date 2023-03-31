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
import com.keka.pageobjects.MyProfilePage;
import com.keka.pageobjects.MyTeamPage;
import com.keka.utility.Log;

/**
 * @author Techversant
 *
 */
public class MyProfilePageTest extends BaseClass {
	
	private LoginPage loginPage;
	private HomePage homePage;
	private MyProfilePage myprofilepage;
	
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
	public void  validateMyProfilePage( String uname, String pswd) throws Throwable {
		Log.startTestCase("MyProfilePageTest");
		loginPage = new LoginPage();
		loginPage.login(uname, pswd, homePage);
	 
		myprofilepage=new MyProfilePage();
		myprofilepage.validateMyProfilePage();
		
		String result=myprofilepage.validateMyProfilePage();
		String Exp = "Rakhi R";
		Assert.assertEquals(result, Exp);
		System.out.println("Profile Page Verified");
		Log.endTestCase("MyProfilePagePageTest");
		myprofilepage.validateAddSignature();
		myprofilepage.validateIdentityDocs();
		
	}
}

/**
 * 
 */
package com.keka.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.keka.base.BaseClass;
import com.keka.dataprovider.DataProviders;
import com.keka.pageobjects.HomePage;
import com.keka.pageobjects.LoginPage;
import com.keka.pageobjects.MyTeamPage;

import com.keka.utility.Log;

/**
 * @author Techversant
 *
 */
public class MyTeamPageTest extends BaseClass {
	

	private LoginPage loginPage;
	private HomePage homePage;
	private MyTeamPage myteampage;
	
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
		Log.startTestCase("EmployeeDirectoryPageTest");
		loginPage = new LoginPage();
		loginPage.login(uname, pswd, homePage);
	  //  homePage=new HomePage();
	    myteampage=new MyTeamPage();
	    myteampage.validateMyTeamPage();

}
}

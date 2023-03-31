/**
 * 
 */
package com.keka.testcases;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.keka.base.BaseClass;
import com.keka.dataprovider.DataProviders;
import com.keka.pageobjects.HomePage;
import com.keka.pageobjects.LoginPage;
import com.keka.utility.Log;

public class LoginPageTest extends BaseClass {

	

	private LoginPage loginPage;
	private HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = { "Smoke", "Sanity","Regression" }, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");

		// homePage=loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		
		loginPage = new LoginPage();
		loginPage.login(uname, pswd, homePage);
		String Act=loginPage.getkekaTitle();
		String Exp = "Techversant Infotech Pvt Ltd";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(Act, Exp, "Techversant Infotech Pvt Ltd");
		Log.info("Login is Sucess");
		Thread.sleep(3000);
		Log.endTestCase("loginTest");
	}
                                             
	}

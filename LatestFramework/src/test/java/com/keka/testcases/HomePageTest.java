/**
 * 
 */
package com.keka.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.keka.base.BaseClass;
import com.keka.dataprovider.DataProviders;
import com.keka.pageobjects.HomePage;
import com.keka.pageobjects.LoginPage;
import com.keka.utility.Log;
import com.keka.utility.MyScreenRecorder;

/**
 * @author Techversant
 *
 */
public class HomePageTest extends BaseClass{
	

	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup( String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void  validateProfileColor( String uname, String pswd) throws Throwable {
		MyScreenRecorder.startRecording("validateProfileColor");
		Log.startTestCase("ProfilecolorTest");
		loginPage = new LoginPage();
		loginPage.login(uname, pswd, homePage);
	    homePage=new HomePage();
		homePage.validateProfileColor();
		Thread.sleep(3000);
		Log.endTestCase("ProfilecolorTest");
		String Act=homePage.getCurrTime();
		System.out.println(Act);
		homePage.validateOnLeaveToday();
		MyScreenRecorder.stopRecording();
	}

}


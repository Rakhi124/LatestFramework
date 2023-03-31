package com.keka.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.keka.actiondriver.Action;
import com.keka.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Techversant: BaseClass is used to load the config file and Initialize
 *         WebDriver
 * 
 */
public class BaseClass {
	public static Properties prop;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	// loadConfig method is to load the configuration
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Evnt.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap

		return driver.get();
	}

	// @Parameters("browser")
	@SuppressWarnings("deprecation")
	public void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {

			/*
			 * ChromeOptions option = new ChromeOptions();
			 * option.addArguments("--remote-allow-origins=*");
			 */

			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		// Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		// PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),
				TimeUnit.SECONDS);
		// Launching the URL

		getDriver().get(prop.getProperty("url"));
	}

	public String getXpathUsername() {
		return prop.getProperty("xpath_uname");

	}

	public String getXpathClick() {
		return prop.getProperty("xpath_click");

	}

	public String getXpathPassword() {
		return prop.getProperty("xpath_password");

	}

	public String getXpathContinueButton() {
		return prop.getProperty("xpath_continuebutton");

	}

	public String getXpathLoginButton() {
		return prop.getProperty("xpath_loginbtn");

	}

	public String getXpathProfileButton() {
		return prop.getProperty("xpath_profilebutton");

	}

	public String getXpathColorButton() {
		return prop.getProperty("xpath_colorbutton");

	}

	public String getXpathColorBox() {
		return prop.getProperty("xpath_colorbox");

	}

	public String getXpathLeave() {
		return prop.getProperty("xpath_leave");

	}

	public String getXpathMyFinanceButton() {
		return prop.getProperty("xpath_myfinancebutton");

	}

	public String getXpathSummaryHeading() {
		return prop.getProperty("xpath_summaryheading");

	}

	public String getXpathManageTax() {
		return prop.getProperty("xpath_managetax");

	}

	public String getXpathWebtable() {
		return prop.getProperty("xpath_webtable");

	}

	public String getXpathListClick() {
		return prop.getProperty("xpath_listclickdeclaration");

	}

	public String getXpathOrgButton() {
		return prop.getProperty("xpath_orgbutton");

	}

	public String getIDDeptButton() {
		return prop.getProperty("id_department");

	}

	public String getXpathCheckbox() {
		return prop.getProperty("xpath_checkbox");

	}

	public String getIDLocationName() {
		return prop.getProperty("id_locationname");

	}

	public String getXpathClearFilter() {
		return prop.getProperty("xpath_clearfilter");

	}

	public String getXpathClearFilterVerification() {
		return prop.getProperty("xpath_clearfilterverification");

	}

	public String getXpathMyTeamButton() {
		return prop.getProperty("xpath_myteam");

	}

	public String getXpathLeaveNotinyet() {
		return prop.getProperty("xpath_leavenotinyet");

	}

	public String getXpathProfileIcon() {
		return prop.getProperty("xpath_profileicon");

	}

	public String getXpathProfileHeading() {
		return prop.getProperty("xpath_actualprofileheading");

	}

	public String getXpathDocument() {
		return prop.getProperty("xpath_document");

	}

	public String getXpathSignature() {
		return prop.getProperty("xpath_signature");

	}

	public String getXpathAddSignature() {
		return prop.getProperty("xpath_addsignature");

	}

	public String getXpathAttachSignature() {
		return prop.getProperty("xpath_attachsignature");

	}

	public String getXpathCloseSignature() {
		return prop.getProperty("xpath_close");

	}

	public String getXpathIdentityDoc() {
		return prop.getProperty("xpath_identitydoc");

	}

	public String getXpathaddDetail() {
		return prop.getProperty("xpath_adddetail");

	}

	public String getXpathAddAttchment() {
		return prop.getProperty("xpath_addattachment");

	}

	public String getFilePath() {
		return prop.getProperty("filepath");

	}

	@AfterSuite(groups = { "Smoke", "Regression", "Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
}

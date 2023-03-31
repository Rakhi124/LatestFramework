/**
 * 
 */
package com.keka.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.keka.actiondriver.Action;
import com.keka.base.BaseClass;

/**
 * @author Hitendra
 * 
 */
public class LoginPage extends BaseClass {

	static Action action = new Action();

	@FindBy(xpath = "//a[text()=' Techversant Infotech Pvt Ltd ']")
	WebElement Actual;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePage login(String uname, String pswd, HomePage homePage) throws Throwable {

		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathClick()));

		action.type(action.getElementsbyXpath(getDriver(), getXpathUsername()), uname);

		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathContinueButton()));

		action.type(action.getElementsbyXpath(getDriver(), getXpathPassword()), pswd);

		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathLoginButton()));
		Thread.sleep(2000);
		return new HomePage();

	}

	public String getkekaTitle() {
		String kekaTitel = Actual.getText();
		return kekaTitel;
	}

}

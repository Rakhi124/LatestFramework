/**
 * 
 */
package com.keka.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.keka.actiondriver.Action;
import com.keka.base.BaseClass;

/**
 * @author Techversant
 *
 */
public class HomePage extends BaseClass {

	static Action action = new Action();
	/*
	 * @FindBy(xpath = "//span[text()='Rakhi R']") WebElement Profilebutton;
	 * 
	 * @FindBy(xpath = "//div[@class='btn-color bg-pink']") WebElement colorButton;
	 * 
	 * @FindBy(xpath = "//div[@class='btn-color bg-pink active']") List<WebElement>
	 * colorbox;
	 * 
	 * @FindBy(xpath = "//div[@class='text-center position-relative mx-4']")
	 * List<WebElement> leave;
	 */

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void validateProfileColor() throws Throwable {

		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathProfileButton()));
		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathColorButton()));

		List<WebElement> color = action.getListElementsbyXpath(getDriver(), getXpathColorBox());
		// action.getListElements(color);
		int t = color.size();
		for (int i = 0; i < t; i++) {
			WebElement element = color.get(i);
			String s = element.getAttribute("class");
			System.out.println(s);
			if (s.contains("btn-color bg-pink active")) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}
		}

	}

	public String getCurrTime() throws Throwable {
		String homePageTime = action.getCurrentTime();
		return homePageTime;
	}

	public void validateOnLeaveToday() {

		List<WebElement> leave = action.getListElementsbyXpath(getDriver(), getXpathLeave());
		action.getListElements(leave);
		/*
		 * System.out.println(leave.size()); for (int i = 0; i < leave.size(); i++) {
		 * String elementText2 = leave.get(i).getText();
		 * System.out.println(elementText2);
		 */

	}
}

/**
 * 
 */
package com.keka.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.keka.actiondriver.Action;
import com.keka.base.BaseClass;

/**
 * @author Techversant
 *
 */
public class MyFinancePage extends BaseClass {

	static Action action = new Action();

	public MyFinancePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String validateSummaryPage() {
		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathMyFinanceButton()));
		String Act = action.getElementsbyXpath(getDriver(), getXpathSummaryHeading()).getText();
		return Act;
	}

	public void validateManageTaxPage() {
		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathManageTax()));
		List<WebElement> tabledata = action.getListElementsbyXpath(getDriver(), getXpathWebtable());
		// System.out.println(tabledata);
		action.getListElements(tabledata);

	}

	public void validateListClick() {
		List<WebElement> list = action.getListElementsbyXpath(getDriver(), getXpathListClick());
		action.ListClick(list);

	}
}

/**
 * 
 */
package com.keka.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.keka.actiondriver.Action;
import com.keka.base.BaseClass;

/**
 * @author Techversant
 *
 */
public class OrgPage extends BaseClass {
	static Action action = new Action();

	public void validateEmployeeDirectoryPage() {
		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathOrgButton()));
		action.JSClick(getDriver(), action.getElementsbyID(getDriver(), getIDDeptButton()));
		List<WebElement> list = action.getListElementsbyXpath(getDriver(), getXpathCheckbox());
		action.Multiselectcheckbox(list);
		
		action.JSClick(getDriver(), action.getElementsbyID(getDriver(), getIDLocationName()));
		List<WebElement> list1 = action.getListElementsbyXpath(getDriver(), getXpathCheckbox());
		action.Multiselectcheckbox(list1);

	}
	public void validateClaerFilter() {
		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathClearFilter()));
	   /*  action.getElementsbyXpath(getDriver(), getXpathClearFilterVerification());
	   // String filterTitle=clearFilterTitle.getText();
	    String filterTitle= action.getTitle(getDriver());
		return filterTitle;*/
	}
}


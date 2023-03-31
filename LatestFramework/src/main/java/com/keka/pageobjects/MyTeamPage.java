/**
 * 
 */
package com.keka.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.keka.actiondriver.Action;
import com.keka.base.BaseClass;
import com.keka.utility.NewExcelLibrary;

/**
 * @author Techversant
 *
 */
public class MyTeamPage extends BaseClass {

	static Action action = new Action();
	NewExcelLibrary obj = new NewExcelLibrary("./src/test/resources/TestData/TestData.xlsx");

	public void validateMyTeamPage() {
		action.JSClick(getDriver(), action.getElementsbyXpath(getDriver(), getXpathMyTeamButton()));

		List<WebElement> list = action.getListElementsbyXpath(getDriver(), getXpathLeaveNotinyet());
		action.getListElements(list);

		boolean flag = obj.addSheet("Sheet1");
		System.out.println("flag value is " + flag);

		obj.addColumn("Sheet1", "Name");

		obj.setCellData("Sheet1", "Name", 2, "Rakhi R");

	}
}

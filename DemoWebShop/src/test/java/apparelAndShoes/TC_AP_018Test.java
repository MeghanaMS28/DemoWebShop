package apparelAndShoes;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import genericLibrary.Base_Class;
import genericLibrary.ExcelUtil;
import pomRepository.ApparelAndShoesPage;

/***
 * 
 * @author Meghana M S
 *
 */

public class TC_AP_018Test extends Base_Class {
	@Test
	public void AddTheProductToCompareListAndRemove() {
		ExcelUtil excelUtil = new ExcelUtil();
		String expectedTitle = excelUtil.readStringDataFromExcel("Sheet1", 10, 0);
		String expectedModuleTitle = excelUtil.readStringDataFromExcel("Sheet1", 11, 0);
		String expectedCompareTitle = excelUtil.readStringDataFromExcel("Sheet1", 16, 0);
		String expectedCompareListText = excelUtil.readStringDataFromExcel("Sheet1", 17, 0);

		ApparelAndShoesPage apparelAndShoesPage = new ApparelAndShoesPage(driver);

		Assert.assertEquals(driver.getTitle(), expectedTitle, "Home Page is not displayed");
		Reporter.log("Home Page is displayed", true);
		homePage.getApparelModuleLink().click();

		Assert.assertEquals(driver.getTitle(), expectedModuleTitle, "Apparel And shoes page is not displayed");
		Reporter.log("Apparel and shoes page is displayed", true);
		apparelAndShoesPage.getClickOnProduct3().click();
		apparelAndShoesPage.getClickOnCompareList().click();

		Assert.assertEquals(driver.getTitle(), expectedCompareTitle, "Compare List page is not displayed");
		Reporter.log("Compare List page is displayed", true);
		apparelAndShoesPage.getClickOnRemoveButton().click();

		Assert.assertEquals(driver.getTitle(), expectedCompareTitle, "Compare List page is not displayed");
		Reporter.log("Compare List page is displayed", true);
		String compareText = apparelAndShoesPage.getTextOfCompareList().getText();
		Assert.assertEquals(compareText, expectedCompareListText, "Compare List page is not Empty");
		Reporter.log("Compare List page is Empty", true);

	}

}

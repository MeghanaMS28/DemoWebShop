package apparelAndShoes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import genericLibrary.ExcelUtil;
import pomRepository.ApparelAndShoesPage;
import pomRepository.ShoppingCartPage;

public class TC_AP_017Test extends Base_Class {
	@Test
	public void AddAndRemoveProductFromCart() {
		ExcelUtil excelUtil = new ExcelUtil();
        String sizeOfDress = excelUtil.readStringDataFromExcel("Sheet1", 3, 0);
		String expectedTitle = excelUtil.readStringDataFromExcel("Sheet1", 10, 0);
		String expectedModuleTitle=excelUtil.readStringDataFromExcel("Sheet1", 11,0);
		String expectedShoppingCartTitle=excelUtil.readStringDataFromExcel("Sheet1", 12,0);
		String expectedShoopingCartResult=excelUtil.readStringDataFromExcel("Sheet1",15, 0);



		ApparelAndShoesPage apparelAndShoesPage = new ApparelAndShoesPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Home Page is not displayed");
		Reporter.log("Home Page is displayed",true);
		homePage.getApparelModuleLink().click();
		
		Assert.assertEquals(driver.getTitle(), expectedModuleTitle, "Apparel And shoes page is not displayed");
		Reporter.log("Apparel and shoes page is displayed",true);
		apparelAndShoesPage.getClickOnProduct3().click();
		WebElement size = apparelAndShoesPage.getClickOnSizeDropdown();
		Select select = new Select(size);
		select.isMultiple();
		select.selectByValue(sizeOfDress);
		apparelAndShoesPage.getClickOnAddToCart().click();
		
		shoppingCartPage.getClickOnShoppingCart().click();
		Assert.assertEquals(driver.getTitle(), expectedShoppingCartTitle, "Shopping Cart page is not displayed");
		Reporter.log("Shopping Cart page is displayed",true);
		shoppingCartPage.getClickOnRemove().click();
		shoppingCartPage.getClickOnUpdateButton().click();
		
		String removeText = shoppingCartPage.getShoppingCardResult().getText();
		Assert.assertEquals(removeText, expectedShoopingCartResult, "Shopping Cart  is Empty");
		Reporter.log("Shopping Cart is not Empty",true);

	}
}

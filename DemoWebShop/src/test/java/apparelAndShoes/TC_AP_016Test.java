package apparelAndShoes;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import genericLibrary.ExcelUtil;
import pomRepository.ApparelAndShoesPage;
import pomRepository.BillingAddressPage;
import pomRepository.ConfirmOrderPage;
import pomRepository.PaymentMethodInfoPage;
import pomRepository.PaymentMethodPage;
import pomRepository.ShippingAddressPage;
import pomRepository.ShippingMethodPage;
import pomRepository.ShoppingCartPage;

/***
 * 
 * @author Meghana M S
 *
 */

public class TC_AP_016Test extends Base_Class {

	@Test
	public void PlaceOrderUsingCashOnDelivery() {
		// Read data from Excel file
		ExcelUtil excelUtil = new ExcelUtil();
		String countryName = excelUtil.readStringDataFromExcel("Sheet1", 0, 2);
		String expectedTitle = excelUtil.readStringDataFromExcel("Sheet1", 10, 0);
		String expectedModuleTitle = excelUtil.readStringDataFromExcel("Sheet1", 11, 0);
		String expectedShoppingCartTitle = excelUtil.readStringDataFromExcel("Sheet1", 12, 0);
		String expectedBillingAddressTitle = excelUtil.readStringDataFromExcel("Sheet1", 13, 0);
		String expectedConfirmOrderPageText = excelUtil.readStringDataFromExcel("Sheet1", 14, 0);

		// Creating Object for POM Repository
		ApparelAndShoesPage apparelAndShoesPage = new ApparelAndShoesPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
		ShippingAddressPage shippingAddressPage = new ShippingAddressPage(driver);
		ShippingMethodPage shippingMethodPage = new ShippingMethodPage(driver);
		PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
		PaymentMethodInfoPage paymentMethodInfoPage = new PaymentMethodInfoPage(driver);
		ConfirmOrderPage confirmOderPage = new ConfirmOrderPage(driver);

		Assert.assertEquals(driver.getTitle(), expectedTitle, "Home Page is not displayed");
		Reporter.log("Home Page is displayed", true);
		homePage.getApparelModuleLink().click();

		// Click on product link
		Assert.assertEquals(driver.getTitle(), expectedModuleTitle, "Apparel And shoes page is not displayed");
		Reporter.log("Apparel and shoes page is displayed", true);
		apparelAndShoesPage.getClickOnProduct2().click();
		apparelAndShoesPage.getClickOnAddToCart1().click();

		shoppingCartPage.getClickOnShoppingCart().click();
		Assert.assertEquals(driver.getTitle(), expectedShoppingCartTitle, "Shopping Cart page is not displayed");
		Reporter.log("Shopping Cart page is displayed", true);

		WebElement country = shoppingCartPage.getClickOnCountryDropdown();
		Select select = new Select(country);
		select.isMultiple();
		select.selectByVisibleText(countryName);

		shoppingCartPage.getClickOnCheckbox().click();
		shoppingCartPage.getClickOnCheckOut().click();

		Assert.assertEquals(driver.getTitle(), expectedBillingAddressTitle, "Billing Address  page is not displayed");
		Reporter.log("Billing Address  page is displayed", true);
		billingAddressPage.getClickOnContinue().click();

		shippingAddressPage.getClickOnShippingSave().click();
		shippingMethodPage.getClickOnShippingContinue().click();
		paymentMethodPage.getClickOnPaymentContinue().click();
		paymentMethodInfoPage.getClickOnPaymentContinue().click();
		confirmOderPage.getClickOnConfirmOrder().click();
		String text = confirmOderPage.getConfirmOrderText().getText();
		Assert.assertEquals(text, expectedConfirmOrderPageText, "Confirm Order  page is not displayed");
		Reporter.log("Confirm Order  page is displayed", true);
	}

}

package apparelAndShoes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.github.dockerjava.api.model.SELContext;

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

public class TC_AP_019Test extends Base_Class {
	@Test
	public void PlaceOrderProductUsingCreditCard() {
		//Reading Data from Excel file
		ExcelUtil excelUtil = new ExcelUtil();
		String countryName = excelUtil.readStringDataFromExcel("Sheet1", 0, 2);
		String cartType = excelUtil.readStringDataFromExcel("Sheet1", 4, 0);
		String name = excelUtil.readStringDataFromExcel("Sheet1", 5, 0);
		String cardNumber = excelUtil.readStringDataFromExcel("Sheet1", 6, 0);
		String expireMonth = excelUtil.readStringDataFromExcel("Sheet1", 7, 0);
		String expireYear = excelUtil.readStringDataFromExcel("Sheet1", 8, 0);
		String cardCode = excelUtil.readStringDataFromExcel("Sheet1", 9, 0);
		String expectedTitle = excelUtil.readStringDataFromExcel("Sheet1", 10, 0);
		String expectedModuleTitle = excelUtil.readStringDataFromExcel("Sheet1", 11, 0);
		String expectedShoppingCartTitle = excelUtil.readStringDataFromExcel("Sheet1", 12, 0);
		String expectedBillingAddressTitle = excelUtil.readStringDataFromExcel("Sheet1", 13, 0);
		String expectedConfirmOrderPageText = excelUtil.readStringDataFromExcel("Sheet1", 14, 0);
        
		//Creating Object for POM Repository
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
		
		//Click on Apparel and Shoes Link 
		homePage.getApparelModuleLink().click();
		Assert.assertEquals(driver.getTitle(), expectedModuleTitle, "Apparel And shoes page is not displayed");
		Reporter.log("Apparel and shoes page is displayed", true);
		
		//Click on Blue and Green Sneakers product
		apparelAndShoesPage.getClickOnProduct2().click();
		
		//Click on Add to Cart 
		apparelAndShoesPage.getClickOnAddToCart1().click();
		
		//Click on shopping cart
		shoppingCartPage.getClickOnShoppingCart().click();
		Assert.assertEquals(driver.getTitle(), expectedShoppingCartTitle, "Shopping Cart page is not displayed");
		Reporter.log("Shopping Cart page is displayed", true);

		//Select the country name
		WebElement country = shoppingCartPage.getClickOnCountryDropdown();
		Select select = new Select(country);
		select.isMultiple();
		select.selectByVisibleText(countryName);

		//Select the check box
		shoppingCartPage.getClickOnCheckbox().click();
		shoppingCartPage.getClickOnCheckOut().click();

		Assert.assertEquals(driver.getTitle(), expectedBillingAddressTitle, "Billing Address  page is not displayed");
		Reporter.log("Billing Address  page is displayed", true);
		billingAddressPage.getClickOnContinue().click();
		shippingAddressPage.getClickOnShippingSave().click();
		shippingMethodPage.getClickOnShippingContinue().click();

		paymentMethodPage.getSelectOnCreditCardRadioButton().click();
		paymentMethodPage.getClickOnPaymentContinue().click();

		//Select the card type
		WebElement card = paymentMethodInfoPage.getClickOnCreditCardTypeDropdown();
		Select select1 = new Select(card);
		select1.isMultiple();
		select1.selectByVisibleText(cartType);
		
		//Enter the Card holder Name
		paymentMethodInfoPage.getEnterCardHolderName().sendKeys(name);
		
		//Enter the card number
		paymentMethodInfoPage.getEnterCardNumber().sendKeys(cardNumber);

		//Select the expire Month
		WebElement month = paymentMethodInfoPage.getSelectMonth();
		Select select2 = new Select(month);
		select2.isMultiple();
		select2.selectByVisibleText(expireMonth);

		//Select the expire Year
		WebElement year = paymentMethodInfoPage.getSelectYear();
		Select select3 = new Select(year);
		select3.isMultiple();
		select3.selectByVisibleText(expireYear);
		
		//Enter the Card code
		paymentMethodInfoPage.getEnterCardCode().sendKeys(cardCode);
		paymentMethodInfoPage.getClickOnPaymentContinue().click();
		confirmOderPage.getClickOnConfirmOrder().click();
		String text = confirmOderPage.getConfirmOrderText().getText();
		Assert.assertEquals(text, expectedConfirmOrderPageText, "Confirm Order  page is not displayed");
		Reporter.log("Confirm Order  page is displayed", true);
	}

}

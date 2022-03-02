package apparelAndShoes;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import genericLibrary.ExcelUtil;
import pomRepository.ApparelAndShoesPage;

public class TC_AP_015Test extends Base_Class{
	
	
	@Test
	public void AddProductToCart() {
		//Reading data from Excel file
		ExcelUtil excelUtil = new ExcelUtil();
		String quantity = excelUtil.readStringDataFromExcel("Sheet1", 1, 0);
		String sizeOfShoe = excelUtil.readStringDataFromExcel("Sheet1", 2, 0);
		String expectedTitle = excelUtil.readStringDataFromExcel("Sheet1", 10, 0);
		String expectedModuleTitle=excelUtil.readStringDataFromExcel("Sheet1", 11,0);
		
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Home Page is not displayed");
		Reporter.log("Home Page is displayed",true);
		//Click on Apparel and shoes link
		homePage.getApparelModuleLink().click();
		ApparelAndShoesPage apparelAndShoesPage = new ApparelAndShoesPage(driver);
		Assert.assertEquals(driver.getTitle(), expectedModuleTitle, "Apparel And shoes page is not displayed");
		Reporter.log("Apparel and shoes page is displayed",true);
		//Click on product1 link
		apparelAndShoesPage.getClickOnProduct1().click();
		//Select the size of shoe
		WebElement size = apparelAndShoesPage.getClickOnSize();
		Select select = new Select(size);
		select.isMultiple();
		select.selectByValue(sizeOfShoe);
		//Select the color of shoe
		apparelAndShoesPage.getClickOnColor().click();
		//Select the number of quantity 
	   WebElement setQuntity = apparelAndShoesPage.getEnterQuantity();
	   setQuntity.clear();
	   setQuntity.sendKeys(quantity);
	   apparelAndShoesPage.getClickOnAddToCart().click();
	}
}

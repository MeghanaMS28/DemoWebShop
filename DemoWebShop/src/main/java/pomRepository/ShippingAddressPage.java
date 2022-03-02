package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressPage {
	public ShippingAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@onclick = 'Shipping.save()']")private WebElement clickOnShippingSave;

	public WebElement getClickOnShippingSave() {
		return clickOnShippingSave;
	}


}

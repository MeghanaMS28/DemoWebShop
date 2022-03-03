package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * 
 * @author Meghana M S
 *
 */
public class BillingAddressPage {
	public BillingAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement clickOnCountryName;

	@FindBy(xpath = "//input[@onclick = 'Billing.save()']")
	private WebElement clickOnContinue;

	public WebElement getClickOnContinue() {
		return clickOnContinue;
	}

	public WebElement getClickOnCountryName() {
		return clickOnCountryName;
	}

}

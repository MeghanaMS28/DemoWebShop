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
public class ShippingMethodPage {
	public ShippingMethodPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement clickOnShippingContinue;

	public WebElement getClickOnShippingContinue() {
		return clickOnShippingContinue;
	}

}

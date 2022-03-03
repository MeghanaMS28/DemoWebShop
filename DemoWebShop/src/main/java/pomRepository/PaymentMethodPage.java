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
public class PaymentMethodPage {
	public PaymentMethodPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement clickOnPaymentContinue;

	@FindBy(xpath = "//label[text()='Credit Card']")
	private WebElement selectOnCreditCardRadioButton;

	public WebElement getSelectOnCreditCardRadioButton() {
		return selectOnCreditCardRadioButton;
	}

	public WebElement getClickOnPaymentContinue() {
		return clickOnPaymentContinue;
	}

}

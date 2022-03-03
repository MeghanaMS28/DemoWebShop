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
public class ConfirmOrderPage {
	public ConfirmOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	private WebElement clickOnConfirmOrder;

	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	private WebElement confirmOrderText;

	public WebElement getConfirmOrderText() {
		return confirmOrderText;
	}

	public WebElement getClickOnConfirmOrder() {
		return clickOnConfirmOrder;
	}

}

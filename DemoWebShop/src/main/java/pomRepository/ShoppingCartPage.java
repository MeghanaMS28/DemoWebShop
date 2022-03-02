package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Shopping cart") private WebElement clickOnShoppingCart;
	
	@FindBy(name = "updatecart") private WebElement clickOnUpdateButton;
	
	@FindBy(id = "CountryId")private WebElement clickOnCountryDropdown;
	
	@FindBy(id = "termsofservice")private WebElement clickOnCheckbox;
	
	@FindBy(id = "checkout")private WebElement clickOnCheckOut;
	
	@FindBy(name = "removefromcart")private WebElement clickOnRemove;
	
	@FindBy(xpath = "//div[contains(text(),'Your Shopping Cart is empty!')]")private WebElement shoppingCardResult;
	
	public WebElement getShoppingCardResult() {
		return shoppingCardResult;
	}

	public WebElement getClickOnRemove() {
		return clickOnRemove;
	}

	public WebElement getClickOnCheckOut() {
		return clickOnCheckOut;
	}

	public WebElement getClickOnCheckbox() {
		return clickOnCheckbox;
	}

	public WebElement getClickOnCountryDropdown() {
		return clickOnCountryDropdown;
	}

	public WebElement getClickOnUpdateButton() {
		return clickOnUpdateButton;
	}

	public WebElement getClickOnShoppingCart() {
		return clickOnShoppingCart;
	}
	

}

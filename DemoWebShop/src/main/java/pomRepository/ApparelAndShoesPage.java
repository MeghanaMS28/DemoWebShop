package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparelAndShoesPage {
	
	public ApparelAndShoesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText  = "Blue and green Sneaker") private WebElement clickOnProduct1;
	
	@FindBy(id = "product_attribute_28_7_10") private WebElement clickOnSize;
	
	@FindBy(xpath = "//span[@title='Black']") private WebElement clickOnColor;
	
	@FindBy(xpath = "//input[@data-val-number='The field Qty must be a number.']") private WebElement enterQuantity;
	
	@FindBy(xpath = "//input[@value='Add to cart']") private WebElement clickOnAddToCart;
	
	@FindBy(linkText = "Blue Jeans") private WebElement clickOnProduct2;
	
	@FindBy(id = "add-to-cart-button-36") private WebElement clickOnAddToCart1;
	
	@FindBy(partialLinkText = "50's Rockabilly Polka")private WebElement clickOnProduct3;
	
	@FindBy(id = "product_attribute_5_7_1")private WebElement clickOnSizeDropdown;
	
	@FindBy(xpath = "//input[@value='Add to compare list']")private WebElement clickOnCompareList;
	
	@FindBy(xpath = "//input[@title='Remove']")private WebElement clickOnRemoveButton;
	
	@FindBy(xpath = "//div[@class='page-body']")private WebElement textOfCompareList;

	public WebElement getTextOfCompareList() {
		return textOfCompareList;
	}

	public WebElement getClickOnCompareList() {
		return clickOnCompareList;
	}

	public WebElement getClickOnRemoveButton() {
		return clickOnRemoveButton;
	}

	public WebElement getClickOnSizeDropdown() {
		return clickOnSizeDropdown;
	}

	public WebElement getClickOnProduct3() {
		return clickOnProduct3;
	}

	public WebElement getClickOnAddToCart1() {
		return clickOnAddToCart1;
	}

	public WebElement getClickOnProduct1() {
		return clickOnProduct1;
	}

	public WebElement getClickOnProduct2() {
		return clickOnProduct2;
	}

	public WebElement getClickOnAddToCart() {
		return clickOnAddToCart;
	}

	public WebElement getEnterQuantity() {
		return enterQuantity;
	}

	public WebElement getClickOnColor() {
		return clickOnColor;
	}

	public WebElement getClickOnSize() {
		return clickOnSize;
	}

}

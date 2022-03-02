package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodInfoPage {
	public PaymentMethodInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")private WebElement clickOnPaymentContinue;
	
	@FindBy(id = "CreditCardType")private WebElement clickOnCreditCardTypeDropdown;
	
	@FindBy(id = "CardholderName")private WebElement enterCardHolderName;
	
	@FindBy(id = "CardNumber")private WebElement enterCardNumber;
	
    @FindBy(id = "ExpireMonth")private WebElement selectMonth;
	
	@FindBy(id = "ExpireYear")private WebElement selectYear;
	
	@FindBy(id = "CardCode")private WebElement enterCardCode;
	
	public WebElement getClickOnCreditCardTypeDropdown() {
		return clickOnCreditCardTypeDropdown;
	}

	public WebElement getEnterCardHolderName() {
		return enterCardHolderName;
	}

	public WebElement getEnterCardNumber() {
		return enterCardNumber;
	}

	public WebElement getSelectMonth() {
		return selectMonth;
	}

	public WebElement getSelectYear() {
		return selectYear;
	}

	
	public WebElement getEnterCardCode() {
		return enterCardCode;
	}

	public WebElement getClickOnPaymentContinue() {
		return clickOnPaymentContinue;
	}


}

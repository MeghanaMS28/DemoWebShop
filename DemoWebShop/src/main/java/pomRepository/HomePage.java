package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Log out") private WebElement logoutButton;
	
	@FindBy(partialLinkText="Apparel & Shoes") private WebElement ApparelModuleLink;

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getApparelModuleLink() {
		return ApparelModuleLink;
	}

	// Business Logic or Action methods or Behavior
	public void logout() {
		logoutButton.click();
	}
}

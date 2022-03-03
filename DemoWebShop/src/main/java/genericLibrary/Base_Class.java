package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genericLibrary.FrameworkConstants;
import genericLibrary.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.HomePage;
import pomRepository.LoginPage;

/***
 * 
 * @author Sumanth Keshav
 *
 */
public class Base_Class implements FrameworkConstants {

	public static WebDriver driver;
	public WebDriverWait explicitWait;
	public PropertyFileReader readFromPropertyFile;
	public LoginPage loginPage;
	public HomePage homePage;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openTheBrowser(@Optional("chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("Successfully Launched Chrome Browser", true);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("Successfully Launched Firefox Browser", true);
		} else {
			Reporter.log("Enter valid Browser name");
		}
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized successfully", true);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() {
		readFromPropertyFile = new PropertyFileReader();
		String url = readFromPropertyFile.getValueProperty("url");
		String username = readFromPropertyFile.getValueProperty("username");
		String password = readFromPropertyFile.getValueProperty("password");

		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(username, password);
	}

	@AfterMethod(alwaysRun = true)
	public void logoutOfApplication() {
		homePage.logout();
	}

	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() {
		driver.quit();
	}
}

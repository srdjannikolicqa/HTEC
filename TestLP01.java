package Exam;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLP01 extends Base {

	WebDriver driver;
	private LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dweomer\\Desktop\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to(PageURLs.LOGIN_PAGE);
		driver.manage().window().maximize();
		this.loginPage = new LoginPage(driver);
	}

	@Test
	public void LP003() {
		this.loginPage.clickSubmitButton();
		List<String> tmp = this.loginPage.textErrorMessage();
		Assert.assertTrue(tmp.get(0).equals("Email field is required") && tmp.get(1).equals("Password is required"));
		driver.close();
	}

	@Test
	public void LP004() {
		this.loginPage.sendTextToEmailAddress("1");
		this.loginPage.clickSubmitButton();
		Assert.assertTrue(this.loginPage.messageEmailAddress().equals("Please enter an email address."));
		driver.close();
	}

	@Test
	public void LP005() {
		this.loginPage.sendTextToEmailAddress("@");
		this.loginPage.clickSubmitButton();
		Assert.assertTrue(this.loginPage.messageEmailAddress().equals("Please enter an email address."));
		driver.close();
	}

	@Test
	public void LP006() {
		this.loginPage.sendTextToEmailAddress("1@");
		this.loginPage.clickSubmitButton();
		Assert.assertTrue(this.loginPage.messageEmailAddress().equals("Please enter an email address."));
		driver.close();
	}

	@Test
	public void LP007() {
		this.loginPage.sendTextToEmailAddress("1@1");
		this.loginPage.clickSubmitButton();
		List<String> tmp = this.loginPage.textErrorMessage();
		Assert.assertTrue(tmp.get(0).equals("Email is invalid"));
		driver.close();
	}

	@Test
	public void LP008() {
		this.loginPage.sendTextToEmailAddress("1@com");
		this.loginPage.clickSubmitButton();
		List<String> tmp = this.loginPage.textErrorMessage();
		Assert.assertTrue(tmp.get(0).equals("Email is invalid"));
		driver.close();
	}
}

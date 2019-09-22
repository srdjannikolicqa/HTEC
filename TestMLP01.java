package Exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Exam.PageURLs;

public class TestMLP01 extends Base {
	WebDriver driver;
	private MainLoginPage mainLoginPage;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dweomer\\Desktop\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to(PageURLs.MAIN_LOGIN_PAGE);
		driver.manage().window().maximize();
		this.mainLoginPage = new MainLoginPage(driver);
	}

	@Test
	public void MLP001() throws Exception{
		this.mainLoginPage.clickLogoHTEC();
		this.mainLoginPage.waitPageLoaded();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(driver.getCurrentUrl().equals(PageURLs.MAIN_SITE));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		driver.close();
	}

	@Test
	public void MLP002() {
		this.mainLoginPage.clickLoginButtonCenter();
		this.mainLoginPage.waitPageLoaded();
		Assert.assertTrue(driver.getCurrentUrl().equals(PageURLs.LOGIN_PAGE));
		driver.close();
	}

	@Test
	public void MLP003() {
		this.mainLoginPage.clickQaSandboxButton();
		this.mainLoginPage.waitPageLoaded();
		Assert.assertTrue(driver.getCurrentUrl().equals(PageURLs.MAIN_LOGIN_PAGE));
		driver.close();
	}

	@Test
	public void MLP004() {
		this.mainLoginPage.clickLoginButtonUpper();
		this.mainLoginPage.waitPageLoaded();
		Assert.assertTrue(driver.getCurrentUrl().equals(PageURLs.LOGIN_PAGE));
		driver.close();
	}

	@Test
	public void MLP005() {
		this.mainLoginPage.clickForgotPasswordButtonCenter();
		this.mainLoginPage.waitPageLoaded();
		Assert.assertTrue(driver.getCurrentUrl().equals(PageURLs.FORGOT_PASSWORD_PAGE));
		driver.close();
	}

	@Test
	public void MLP006() {
		this.mainLoginPage.clickForgotPasswordButtonUpper();
		this.mainLoginPage.waitPageLoaded();
		Assert.assertTrue(driver.getCurrentUrl().equals(PageURLs.FORGOT_PASSWORD_PAGE));
		driver.close();
	}

	public String getChildWindow() {
		Set<String> window = driver.getWindowHandles();
		Iterator iterator = window.iterator();
		String currentWindowId = null;
		String mainPage = driver.getWindowHandle();
		while (iterator.hasNext()) {
			currentWindowId = iterator.next().toString();
			// Takes the url from child window
			if (!currentWindowId.equals(mainPage)) {
				driver.switchTo().window(currentWindowId);
			}
		}
		return driver.getCurrentUrl();
	}
}

package Exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainLoginPage extends Base {

	static WebDriver driver;

	public MainLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Elements

	private static WebElement logoHTEC() {
		return driver.findElement(By.cssSelector("footer a"));
	}

	private static WebElement loginButtonCenter() {
		return driver.findElement(By.cssSelector("a.btn-secondary"));
	}

	private static WebElement loginButtonUpper() {
		return driver.findElement(By.cssSelector("a.nav-link[href='/login']"));
	}

	private static WebElement qaSandboxButton() {
		return driver.findElement(By.cssSelector("a.navbar-brand.noselect"));
	}

	private static WebElement forgotPasswordButtonCenter() {
		return driver.findElement(By.cssSelector("a.mr-2"));
	}

	private static WebElement forgotPasswordButtonUpper() {
		return driver.findElement(By.cssSelector("a.nav-link[href='/forgot-password']"));
	}

	// Actions

	public void clickLogoHTEC() {
		logoHTEC().click();
	}

	public void clickLoginButtonCenter() {
		loginButtonCenter().click();
	}

	public void clickLoginButtonUpper() {
		loginButtonUpper().click();
	}

	public void clickQaSandboxButton() {
		qaSandboxButton().click();
	}

	public void clickForgotPasswordButtonCenter() {
		forgotPasswordButtonCenter().click();
	}

	public void clickForgotPasswordButtonUpper() {
		forgotPasswordButtonUpper().click();
	}
}

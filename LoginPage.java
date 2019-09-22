package Exam;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base {

	static WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Elements

	private static WebElement emailAddress() {
		return driver.findElement(By.cssSelector("input.undefined[type='email']"));
	}

	private static WebElement password() {
		return driver.findElement(By.cssSelector("input.undefined[type='password']"));
	}

	private static WebElement submitButton() {
		return driver.findElement(By.cssSelector("button.mt-4"));
	}

	private static List<WebElement> errorMessage() {
		return driver.findElements(By.cssSelector("div.invalid-feedback"));
	}

	// Actions

	public void sendTextToEmailAddress(String email) {
		emailAddress().sendKeys(email);
	}

	public void clickEmailAddress() {
		emailAddress().click();
	}

	public void sendTextToPassword(String password) {
		password().sendKeys(password);
	}

	public void clickPassword() {
		password().click();
	}

	public void clickSubmitButton() {
		submitButton().click();
	}

	public List<String> textErrorMessage() {
		List<String> text = new ArrayList<String>();
		List<WebElement> errorElements = errorMessage();
		for (int i = 0; i < errorElements.size(); i++)
			text.add(errorElements.get(i).getText());
		while (text.size() < 2)
			text.add("");
		return text;
	}

	public String messageEmailAddress() {
		return emailAddress().getAttribute("validationMessage");
	}
}

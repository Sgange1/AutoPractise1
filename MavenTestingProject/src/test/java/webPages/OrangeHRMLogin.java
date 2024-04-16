package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class OrangeHRMLogin extends Seleniumutil {

	// Initialize current class with WebDriver
	public OrangeHRMLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement usernameInputField;

	@FindBy(name = "password")
	private WebElement passwordInputField;

	@FindBy(css = ".orangehrm-login-button")
	private WebElement button;

	public WebElement getUsernameInputField() {
		return usernameInputField;
	}

	public WebElement getPasswordInputField() {
		return passwordInputField;
	}

	public WebElement getButton() {
		return button;
	}

	public void OrangeLogin(String username, String password) {
		typeRequiredText(usernameInputField, username);
		typeRequiredText(passwordInputField, password);
		clickOnElement(button);
	}
}
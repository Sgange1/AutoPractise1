package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class vtigerLogin extends Seleniumutil {

	// Initialize current class with WebDriver
	public vtigerLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement usernameInput;
	
	@FindBy(name="password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginButton;

	public WebElement getUsernameInput() {
		return usernameInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void loginIntoVtiger(String username, String password) {
		typeRequiredText(usernameInput, username);
		typeRequiredText(passwordInput, password);
		clickOnElement(loginButton);
	}
}
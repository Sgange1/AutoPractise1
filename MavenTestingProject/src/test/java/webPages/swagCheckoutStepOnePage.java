package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class swagCheckoutStepOnePage extends Seleniumutil {
	public swagCheckoutStepOnePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);//To initialise all the required elements of Webpage
	}
	@FindBy(id = "first-name")
	private WebElement firstNameInputField;

	public WebElement getfirstNameInputField() {
		return firstNameInputField;
	}

	@FindBy(id = "last-name")
	private WebElement lastNameInputField;

	public WebElement getlastNameInputField() {
		return lastNameInputField;
	}

	@FindBy(id = "postal-code")
	private WebElement postalCodeInputField;

	public WebElement getpostalCodeInputField() {
		return postalCodeInputField;
	}

	@FindBy(id = "continue")
	private WebElement continueButton;

	public WebElement getcontinueButton() {
		return continueButton;
	}

	// Method To enter details n click on continue button for CheckoutStepOne

	public void enterDetailsForCheckout(String firstName, String lastName, String postalCode) {
		typeRequiredText(firstNameInputField, firstName);
		typeRequiredText(lastNameInputField, lastName);
		typeRequiredText(postalCodeInputField, postalCode);
		clickOnElement(continueButton);
	}

}
/**
 * Elements needed on checkoutStepOnePage 
 * firstNameInputField 
 * lastNameInputField
 * postalCodeInputField
 *
 * continueButton
 */
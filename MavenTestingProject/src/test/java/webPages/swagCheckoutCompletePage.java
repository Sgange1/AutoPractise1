package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class swagCheckoutCompletePage extends Seleniumutil {
	
	public swagCheckoutCompletePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);//To initialise all the web elements
	}

	@FindBy(css=".complete-header")
	private WebElement ThankYouMessageElement;
	
	public WebElement getThankYouMessageElement()
	{
		return ThankYouMessageElement;
	}
	
	@FindBy(id="back-to-products")
	private WebElement backToHomeButton;
	
	public WebElement getbackToHomeButton()
	{
		return backToHomeButton;
	}
	
	public String getSuccessMsg()
	{
		return getTextFromElement(ThankYouMessageElement);
	}
}
/*
 * Elements needed on checkoutCompletePage
 * ThankYouMessage
 *backToHomeButton
 */
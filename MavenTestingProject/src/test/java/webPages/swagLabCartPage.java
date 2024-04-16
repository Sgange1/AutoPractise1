package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class swagLabCartPage extends Seleniumutil{
	
	public swagLabCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//button[@name='checkout']")
	private WebElement checkoutButton;
	
	public WebElement getcheckoutButton()
	{
		return checkoutButton;
	}

	public void performCheckout()
	{
		clickOnElement(checkoutButton);
	}
}
/**Elements needed on Home page
 * checkoutButton
 */
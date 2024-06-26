package webPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class swagCheckoutStepTwoPage extends Seleniumutil{
	
	public swagCheckoutStepTwoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".summary_subtotal_label")
	private WebElement purchasedItemsSubTotal;
	
	//getter() for purchasedItemsTotal
	public WebElement getpurchasedItemsSubTotal()
	{
		return purchasedItemsSubTotal;
	}
	
	@FindBy(id="finish")
	private WebElement finishButton;
	
	public WebElement getfinishButton()
	{
		return finishButton;
	}
	
	public void purchasedHistory()
	{
		//items purchased list
		  List<WebElement> items=driver.findElements(By.cssSelector(".inventory_item_name")); ////div[@class='inventory_item_name']
		  //concept of Independant(Item) n dependant child(Item price)
		  List<WebElement> prices=driver.findElements(By.xpath("//div[a[div[@class='inventory_item_name']]]/div[2]/div"));
		  //check total without tax
		  String itemsTotal=driver.findElement(By.cssSelector(".summary_subtotal_label")).getText(); 
		  clickOnElement(finishButton);
	}
}
/**
 * Elements needed on checkoutStepTwoPage
 *Item total: 
 *finishButton
 */
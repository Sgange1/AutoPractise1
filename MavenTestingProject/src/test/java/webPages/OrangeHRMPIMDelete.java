package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class OrangeHRMPIMDelete extends Seleniumutil{

	//Initialize current class with WebDriver
	public OrangeHRMPIMDelete(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement Dpim;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div[1]/div/div[2]/div[1]/div[1]/input[1]")
	private WebElement nameInput;
	@FindBy(className="orangehrm-left-space")
	private WebElement searchname;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[1]/i")
	private WebElement click1;
	@FindBy(xpath="html/body/div/div[3]/div/div/div/div[3]/button[2]")
	private WebElement PIMDeleted;
	public WebElement getDpim() {
		return Dpim;
	}
	public WebElement getNameInput() {
		return nameInput;
	}
	public WebElement getSearchname() {
		return searchname;
	}
	public WebElement getClick1() {
		return click1;
	}
	public WebElement getPIMDeleted() {
		return PIMDeleted;
	}
	public void OrangePIMCreate(String name) {
		clickOnElement(Dpim);
		typeRequiredText(nameInput, name);
		clickOnElement(searchname);
		clickOnElement(click1);
		clickOnElement(PIMDeleted);
	
}
}
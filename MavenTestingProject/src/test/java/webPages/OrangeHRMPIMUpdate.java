package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.Seleniumutil;

public class OrangeHRMPIMUpdate extends Seleniumutil {

	// Initialize current class with WebDriver
	public OrangeHRMPIMUpdate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement UpdatePIM;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div[1]/div/div[2]/div[1]/div[1]/input[1]")
	private WebElement searchnameInput;
	@FindBy(className="orangehrm-left-space")
	private WebElement button;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]/i")
	private WebElement click;
	@FindBy(name="lastName")
	private WebElement lastnameupdate;
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/form/div[2]/button")
	private WebElement buttonclick;
	public WebElement getUpdatePIM() {
		return UpdatePIM;
	}
	public WebElement getSearchname() {
		return searchnameInput;
	}
	public WebElement getButton() {
		return button;
	}
	public WebElement getClick() {
		return click;
	}
	public WebElement getLastnameupdate() {
		return lastnameupdate;
	}
	public WebElement getButtonclick() {
		return buttonclick;
	}
	public void OrangePIMUpdate(String searchname, String lastnameu) {
		clickOnElement(UpdatePIM);
		typeRequiredText(searchnameInput, searchname);
		clickOnElement(button);
		clickOnElement(click);
		typeRequiredText(lastnameupdate, lastnameu);
		clickOnElement(buttonclick);

}
}
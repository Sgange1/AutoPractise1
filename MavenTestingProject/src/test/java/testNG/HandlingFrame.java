package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class HandlingFrame extends Seleniumutil {
	@Test
	public void loginIntoActitime() {
		WebDriver driver = setUp("chrome", "https://jqueryui.com/");

		clickOnElement(driver.findElement(By.xpath("//a[text()='Selectable']")));
		// move control inside the frame to perform required opr on the element
//		WebElement frame=driver.findElement(By.cssSelector(".demo-frame"));
//		driver.switchTo().frame(frame);		
		// or
		driver.switchTo().frame(0);

		clickOnElement(driver.findElement(By.xpath("//li[text()='Item 2']")));

		// to get the control back to main page use
		driver.switchTo().defaultContent();
		clickOnElement(driver.findElement(By.cssSelector(".logo")));

	}
}

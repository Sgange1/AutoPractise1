package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class AlertHandling extends Seleniumutil {
	@Test
	public void loginIntoActitime() {
		WebDriver driver = setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

		driver.switchTo().frame("iframeResult");

		clickOnElement(driver.findElement(By.xpath("//button[text()='Try it']")));

		System.out.println("Alert msg : " + driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

	}
}
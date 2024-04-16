package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class PromptAlertHandling extends Seleniumutil {
	@Test
	public void loginIntoActitime() {
		WebDriver driver = setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		driver.switchTo().frame("iframeResult");

		clickOnElement(driver.findElement(By.xpath("//button[text()='Try it']")));

		System.out.println("Alert msg : " + driver.switchTo().alert().getText());

		driver.switchTo().alert().sendKeys("Shailesh");

//		driver.switchTo().alert().accept();

		driver.switchTo().alert().dismiss();

		System.out.println(driver.findElement(By.id("demo")).getText());

	}
}
package testNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class ActiveElementHandling extends Seleniumutil {
	@Test
	public void loginIntoActitime() {
		WebDriver driver = setUp("chrome", "https://online.actitime.com/cts1/login.do");
		/*
		 * validate mouse pointer is present in username input field or validate focus
		 * is on username input field
		 */
		WebElement element = driver.switchTo().activeElement();
		System.out
				.println("is focus on Username input field? " + element.getAttribute("placeholder").equals("Username"));

		element.sendKeys("admin01", Keys.TAB);
		driver.switchTo().activeElement().sendKeys("admin01", Keys.ENTER);
	}
}
/*
 * validate mouse pointer is present in username input field or validate focus
 * is on username input field
 * 
 * login into application without identifying any element
 * 
 */
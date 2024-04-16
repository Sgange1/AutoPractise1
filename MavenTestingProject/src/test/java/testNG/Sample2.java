package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sampleScript.Seleniumutil;

public class Sample2 extends Seleniumutil {

	@BeforeMethod
	public void preCondition() {
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	public void testOrangeHRM_LoginPage() {

		String expected = "login";
		String actual = getCurrentUrlOfApplication();
		Assert.assertTrue(actual.contains(expected));
	}

	private String getCurrentUrlOfApplication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(priority = 2)
	public void testOrangeHRM_LoginFlow() {

		typeRequiredText(driver.findElement(By.name("username")), "Admin");
		typeRequiredText(driver.findElement(By.name("password")), "admin123");
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
		String expected = "dashboard";
		String actual = getCurrentUrlOfApplication();
		Assert.assertTrue(actual.contains(expected));
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}

package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class SauceDemo extends Seleniumutil  {
  @Test
  public void OpenBrowser1() {
	  WebDriver driver = setUp("chrome", "https://www.saucedemo.com/");
  }
  @Test
  public void Orderplaced2() {
	  typeRequiredText(driver.findElement(By.id("user-name")), "standard_user");
	  typeRequiredText(driver.findElement(By.id("password")), "secret_sauce");
	  clickOnElement(driver.findElement(By.id("login-button")));
	  clickOnElement(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")));
	  clickOnElement(driver.findElement(By.className("shopping_cart_link")));
	  clickOnElement(driver.findElement(By.id("checkout")));
	  typeRequiredText(driver.findElement(By.id("first-name")), "Snehal");
	  typeRequiredText(driver.findElement(By.id("last-name")), "gange");
	  typeRequiredText(driver.findElement(By.id("postal-code")), "431005");
	  clickOnElement(driver.findElement(By.id("continue")));
	  clickOnElement(driver.findElement(By.id("finish")));
	  String actualURL=driver.getCurrentUrl();
	  String expectedURL="https://www.saucedemo.com/checkout-complete.html";
	  Assert.assertEquals(actualURL, expectedURL);
	 
  }
}

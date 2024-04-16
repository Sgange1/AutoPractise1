package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class Vtiger extends Seleniumutil {

	String actualTitle;
	String expectecTitle;

	@BeforeTest
	public void precondition() {

		driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		typeRequiredText(driver.findElement(By.name("username")), "admin");
		typeRequiredText(driver.findElement(By.name("password")), "admin");
		clickOnElement(driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/div[3]/button")));
	}

	@Test(priority = 1)
	public void Contact() {

		actualTitle = driver.getTitle();
		expectecTitle = "Dashboard";
		Assert.assertEquals(actualTitle, expectecTitle);
		clickOnElement(driver.findElement(By.xpath("/html/body/div/nav/div/div/div/div/div/div/span")));
		clickOnElement(driver.findElement(By.xpath("//span[text()=' MARKETING']")));
		// Create
		clickOnElement(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/ul/div/div/li[3]/a/span[2]")));
		clickOnElement(driver.findElement(
				By.xpath("/html/body/div/nav/div[2]/div/div[3]/div/div[2]/div/nav/div/div[2]/ul/li[1]/button[1]")));
		typeRequiredText(driver.findElement(By.name("lastname")), "Jordan");
		typeRequiredText(driver.findElement(By.id("Contacts_editView_fieldName_phone")), "9895949392");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		// Update
		clickOnElement(driver.findElement(By.xpath("//button[text()='Edit']")));
		driver.findElement(By.name("mailingcity")).sendKeys("Pune");

		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		clickOnElement(driver.findElement(
				By.xpath("/html/body/div/div[4]/div/div[2]/div/div/div[1]/div/div[2]/div/div/button[4]/i")));
		clickOnElement(driver.findElement(By.xpath("//a[text()='Delete Contact']")));
		clickOnElement(driver.findElement(By.xpath("//button[text()='Yes']")));
		String expectTitle="Contacts";
		String actTitle=getPageTitle(expectTitle);
		Assert.assertEquals(actTitle, expectTitle);

	}

	@Test(priority = 2)
	public void Lead() {
		// Create lead
		clickOnElement(driver.findElement(By.xpath("/html/body/div/nav/div/div/div/div/div/div/span")));
		clickOnElement(driver.findElement(By.xpath("/html/body/div/div[5]/div/div[2]/div[2]/div/div/span[2]")));
		clickOnElement(driver.findElement(By.xpath("//span[text()=' Leads']")));
		driver.findElement(
				By.xpath("/html/body/div[1]/nav/div[2]/div/div[3]/div/div[2]/div/nav/div/div[2]/ul/li[1]/button"))
				.click();
		typeRequiredText(driver.findElement(By.name("lastname")), "Maxwell");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		// Update
		clickOnElement(driver.findElement(By.xpath("//button[text()='Edit']")));
		typeRequiredText(driver.findElement(By.name("company")), "Cognizant");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Save']")));
		clickOnElement(driver
				.findElement(By.xpath("/html/body/div/div[4]/div/div[2]/div/div/div/div/div[2]/div/div/button[5]/i")));
		clickOnElement(driver.findElement(By.xpath("//a[text()='Delete Lead']")));
		clickOnElement(driver.findElement(By.xpath("//button[text()='Yes']")));
		String expectTitle="Leads";
		String actTitle=getPageTitle(expectTitle);
		Assert.assertEquals(actTitle, expectTitle);
	}

	@AfterTest
	public void exit() {
		driver.close();
	}
}

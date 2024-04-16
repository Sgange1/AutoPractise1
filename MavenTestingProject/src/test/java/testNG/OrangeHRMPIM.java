package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sampleScript.Seleniumutil;

public class OrangeHRMPIM extends Seleniumutil {

	@Test(enabled = true, priority = 1)
	public void Create() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		typeRequiredText(driver.findElement(By.name("username")), "Admin");
		typeRequiredText(driver.findElement(By.name("password")), "admin123");
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
		clickOnElement(driver.findElement(By.xpath("//span[text()='PIM']")));
		System.out.println("Create PIM");
		clickOnElement(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/button")));
		typeRequiredText(driver.findElement(By.name("firstName")), "Lisa");
		typeRequiredText(driver.findElement(By.name("middleName")), "John");
		typeRequiredText(driver.findElement(By.name("lastName")), "Raymond");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[2]/button[2]")).click();
	}

	@Test(enabled = true, priority = 2)
	public void Modify() {
		System.out.println("Updated PIM");
		clickOnElement(driver.findElement(By.xpath("//span[text()='PIM']")));
		typeRequiredText(driver.findElement(By.xpath(
				"/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div[1]/div/div[2]/div[1]/div[1]/input[1]")), "Lisa");
		clickOnElement(driver.findElement(By.className("orangehrm-left-space")));
		clickOnElement(driver.findElement(
				By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]/i")));
		typeRequiredText(driver.findElement(By.name("lastName")), "Raymond2");
		clickOnElement(driver.findElement(
				By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/form/div[2]/button")));

	}

	@Test(enabled = true, priority = 3)
	public void TheEnd() {
		System.out.println("Deleted PIM");
		clickOnElement(driver.findElement(By.xpath("//span[text()='PIM']")));
		driver.findElement(By.xpath(
				"/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div[1]/div/div[2]/div[1]/div[1]/input[1]"))
				.sendKeys("Lisa");
		clickOnElement(driver.findElement(By.className("orangehrm-left-space")));
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[1]/i")).click();
		driver.findElement(By.xpath("html/body/div/div[3]/div/div/div/div[3]/button[2]")).click();

	}

}
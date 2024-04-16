package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example7 {
	
	@BeforeMethod
	public void login() {
		
	}

	@AfterMethod
	public void logout() {
		System.out.println("************Logout from the application***********************");
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("************Close the browser instance***********************");
	}

	@Test
	public void test01() {
		System.out.println("Write a code to create PIM");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("usrename")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.cssSelector("oxd-button--secondary")).click();
		driver.findElement(By.name("firstName")).sendKeys("Ansh");
		driver.findElement(By.name("middleName")).sendKeys("Anup");
		driver.findElement(By.name("lastName")).sendKeys("Patil");
		driver.findElement(By.className("oxd-input--active")).sendKeys("2341");
		driver.findElement(By.className("orangehrm-left-space")).click();
		
	}

	@Test
	public void test02() {
		System.out.println("Write a code to update PIM");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("usrename")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/"
				+ "html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div[2]/div/div[2]/input")).sendKeys("2341");
		driver.findElement(By.className("orangehrm-left-space")).click();
		driver.findElement(By.className("bi-pencil-fill")).click();
		driver.findElement(By.xpath("//span[contains(@class,'--label-right oxd-radio-input')][1]")).click();
		driver.findElement(By.className("oxd-select-text-input")).click();
		driver.findElement(By.className("orangehrm-left-space")).click();
	}

	@Test
	public void test03() {
		System.out.println("Write a code to delete PIM");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("usrename")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/"
				+ "html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div[2]/div/div[2]/input")).sendKeys("2341");
		driver.findElement(By.className("orangehrm-left-space")).click();
		driver.findElement(By.className("oxd-icon bi-trash")).click();
		driver.findElement(By.className("oxd-button--label-danger orangehrm-button-margin")).click();
		
		
	}

	@BeforeTest
	public void openBrowser() {
		System.out.println("************Open browser and enter OrangeHRM URL***********************");
	}
}
package seleniumUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Seleniumutil1 {
	public static void main(String[] args) {
		Seleniumutil util = new Seleniumutil();
		WebDriver driver = util.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		util.typeRequiredText(driver.findElement(By.name("username")), "Admin");
		util.typeRequiredText(driver.findElement(By.name("password")), "admin123");
		util.clickOnElement(driver.findElement(By.className("orangehrm-login-button")));
	}
}

/*
 * Scenario to Automate: Open chrome browser Enter App url as
 * https://opensource-demo.orangehrmlive.com/web/index.php/auth/login Validate
 * login page Enter user name as Admin Password as admin123 Click on login
 * button Validate home page
 * 
 */
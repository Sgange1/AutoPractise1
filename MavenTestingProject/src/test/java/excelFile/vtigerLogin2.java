package excelFile;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ExcelUtility.ExcelUtil;
import seleniumUtility.Seleniumutil;

public class vtigerLogin2 extends Seleniumutil {
	String appUrl;
	String userName;
	String password;
	static int row = 3;//
	static String expectecTitle;
	static String actualTitle;
	String filePath = ".\\src\\test\\resources\\AppTest.xlsx";

	@BeforeMethod
	public void getData() {
		appUrl = ExcelUtil.getCellvalue(filePath, "TC", row, 0);
		userName = ExcelUtil.getCellvalue(filePath, "TC", row, 1);
		password = ExcelUtil.getCellvalue(filePath, "TC", row, 2);
		expectecTitle = ExcelUtil.getCellvalue(filePath, "TC", row, 3);
	}

	@Test
	public void testvtigerLogin() {
		setUp("chrome", appUrl);
		typeRequiredText(driver.findElement(By.id("username")), userName);//
		typeRequiredText(driver.findElement(By.name("password")), password);//
		clickOnElement(driver.findElement(By.xpath("//button[text()='Sign in']")));//
		actualTitle=getPageTitle(expectecTitle);
		Assert.assertEquals(actualTitle, expectecTitle);
	}

	@AfterMethod
	public void cleanUp1() {
		// update current title
		ExcelUtil.updateExcelContent(filePath, "TC", row, 4, actualTitle);
		if (actualTitle.equals(expectecTitle)) {
			ExcelUtil.updateExcelContent(filePath, "TC", row, 5, "Passed");
		} else {
			ExcelUtil.updateExcelContent(filePath, "TC", row, 5, "failed");
		}
	}
}
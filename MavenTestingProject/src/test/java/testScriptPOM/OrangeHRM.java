package testScriptPOM;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import seleniumUtility.Seleniumutil;
import webPages.OrangeHRMLogin;
import webPages.OrangeHRMPIMCreate;
import webPages.OrangeHRMPIMDelete;
import webPages.OrangeHRMPIMUpdate;


public class OrangeHRM extends Seleniumutil {

	WebDriver driver;
	OrangeHRMLogin getOrangeHRMLogin;
	OrangeHRMPIMCreate getOrangeHRMPIMCreate;
	OrangeHRMPIMUpdate getOrangeHRMPIMUpdate;
	OrangeHRMPIMDelete getOrangeHRMPIMDelete;
	String actualTitle;
	String expectecTitle;
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeTest
	public void precondition() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getOrangeHRMLogin = new OrangeHRMLogin(driver);
		getOrangeHRMPIMCreate = new OrangeHRMPIMCreate(driver);
		getOrangeHRMPIMUpdate = new OrangeHRMPIMUpdate(driver);
		getOrangeHRMPIMDelete = new OrangeHRMPIMDelete(driver);
		report = new ExtentReports(".\\ExtentReportResultsOrange.html");
		test = report.startTest("ExtentDemoOrange");
		
	}
	@Test(priority = 1)
	public void OrangeHRMLogin() {
		typeRequiredText(getOrangeHRMLogin.getUsernameInputField(), "Admin");
		typeRequiredText(getOrangeHRMLogin.getPasswordInputField(), "admin123");
		clickOnElement(getOrangeHRMLogin.getButton());
		if (driver.getTitle().equals("OrangeHRM")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
	}
	@Test(priority = 2)
	public void OrangeHRMPIMCreate() {
		clickOnElement(getOrangeHRMPIMCreate.getCreatePIM());
		clickOnElement(getOrangeHRMPIMCreate.getButtonC());
		typeRequiredText(getOrangeHRMPIMCreate.getFirstname(), "Rina");
		typeRequiredText(getOrangeHRMPIMCreate.getMiddleName(), "Mark");
		typeRequiredText(getOrangeHRMPIMCreate.getLastName(), "Deven");
		clickOnElement(getOrangeHRMPIMCreate.getPIMcreated());
		actualTitle=driver.getCurrentUrl();
		expectecTitle="pim";
		Assert.assertTrue(actualTitle.contains(expectecTitle));
		test.log(LogStatus.PASS, "PIM Created");


	}
	@Test(priority = 3)
	public void OrangeHRMPIMUpdate() {
		clickOnElement(getOrangeHRMPIMUpdate.getUpdatePIM());
		typeRequiredText(getOrangeHRMPIMUpdate.getSearchname(), "Rina");
		clickOnElement(getOrangeHRMPIMUpdate.getButton());
		clickOnElement(getOrangeHRMPIMUpdate.getClick());
		typeRequiredText(getOrangeHRMPIMUpdate.getLastnameupdate(), "Deven2");
		clickOnElement(getOrangeHRMPIMUpdate.getButtonclick());
		actualTitle=driver.getCurrentUrl();
		expectecTitle="empNumber";
		Assert.assertTrue(actualTitle.contains(expectecTitle));
		test.log(LogStatus.PASS, "PIM Updated");
	}
	
	@Test(priority = 4)
	public void OrangeHRMPIMDelete() {
		clickOnElement(getOrangeHRMPIMDelete.getDpim());
		typeRequiredText(getOrangeHRMPIMDelete.getNameInput(), "Rina");
		clickOnElement(getOrangeHRMPIMDelete.getSearchname());
		clickOnElement(getOrangeHRMPIMDelete.getClick1());
		clickOnElement(getOrangeHRMPIMDelete.getPIMDeleted());
		actualTitle=driver.getCurrentUrl();
		expectecTitle="viewEmployeeList";
		Assert.assertTrue(actualTitle.contains(expectecTitle));
		test.log(LogStatus.PASS, "PIM Deleted");


	}
	@AfterTest
	public void postcondition() {
		driver.close();
		report.endTest(test);
		report.flush();
	}
	
}
package testScriptPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import seleniumUtility.Seleniumutil;
import webPages.VtigerCreateContactPage;
import webPages.VtigerDeleteContact;
import webPages.VtigerLeadCreate;
import webPages.VtigerLeadDelete;
import webPages.VtigerLeadUpdate;
import webPages.VtigerUpdateContact;
import webPages.vtigerLogin;

public class vTigerScript extends Seleniumutil {

	WebDriver driver;
	vtigerLogin getvtigerLogin;
	VtigerCreateContactPage getVtigerCreateContactPage;
	VtigerUpdateContact getVtigerUpdateContact;
	VtigerDeleteContact getVtigerDeleteContact;
	VtigerLeadCreate getVtigerLeadCreate;
	VtigerLeadUpdate getVtigerLeadUpdate;
	VtigerLeadDelete getVtigerLeadDelete;
	String actTitle;
	String expectTitle;
	String actUrl;
	String expectUrl;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeTest
	public void precondition() {
		driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		getvtigerLogin = new vtigerLogin(driver);
		getVtigerCreateContactPage = new VtigerCreateContactPage(driver);
		getVtigerUpdateContact = new VtigerUpdateContact(driver);
		getVtigerDeleteContact = new VtigerDeleteContact(driver);
		getVtigerLeadCreate = new VtigerLeadCreate(driver);
		getVtigerLeadUpdate = new VtigerLeadUpdate(driver);
		getVtigerLeadDelete = new VtigerLeadDelete(driver);
		report = new ExtentReports(".\\ExtentReportResultsVtiger.html");
		test = report.startTest("ExtentDemoVtiger");

	}

	@Test(priority = 1)
	public void VtigerL() {
		typeRequiredText(getvtigerLogin.getUsernameInput(), "admin");
		typeRequiredText(getvtigerLogin.getPasswordInput(), "admin");
		clickOnElement(getvtigerLogin.getLoginButton());
		if (driver.getTitle().equals("Dashboard")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		

	}

	@Test(priority = 2)
	public void VtigerCreateContact() {
		clickOnElement(getVtigerCreateContactPage.getDropdown());
		clickOnElement(getVtigerCreateContactPage.getMarketingselect());
		clickOnElement(getVtigerCreateContactPage.getContactselect());
		clickOnElement(getVtigerCreateContactPage.getAddcontact());
		typeRequiredText(driver.findElement(By.name("lastname")), "Rose");
		typeRequiredText(driver.findElement(By.id("Contacts_editView_fieldName_phone")), "123");
		clickOnElement(getVtigerCreateContactPage.getSave());
		test.log(LogStatus.PASS, "Contact created");
	}

	@Test(priority = 3)
	public void VtigerUpdateContact() {

		clickOnElement(getVtigerUpdateContact.getEdit());
		typeRequiredText(driver.findElement(By.name("mailingcity")), "Mumbai");
		clickOnElement(getVtigerUpdateContact.getSave());
		test.log(LogStatus.PASS, "Contact Updated");
	}

	@Test(priority = 4)
	public void VtigerDeleteContact() {
		clickOnElement(getVtigerDeleteContact.getDelete());
		clickOnElement(getVtigerDeleteContact.getDeleteContact());
		clickOnElement(getVtigerDeleteContact.getYes());
		expectTitle = "Contacts";
		actTitle = getPageTitle(expectTitle);
		Assert.assertEquals(actTitle, expectTitle);
		test.log(LogStatus.PASS, "Contact Deleted");
	}

	@Test(priority = 5)
	public void VtigerLeadPIMCreate() {
		clickOnElement(getVtigerCreateContactPage.getDropdown());
		clickOnElement(getVtigerLeadCreate.getMarketingselect());
		clickOnElement(getVtigerLeadCreate.getLeadselect());
		clickOnElement(getVtigerLeadCreate.getLeadcreate());
		typeRequiredText(driver.findElement(By.name("lastname")), "Marvel");
		clickOnElement(getVtigerLeadCreate.getLeadsave());
		test.log(LogStatus.PASS, "Lead Created");

	}

	@Test(priority = 6)
	public void VtigerLeadPIMUpdate() {
		clickOnElement(getVtigerLeadUpdate.getLeadedit());
		typeRequiredText(driver.findElement(By.name("mobile")), "876");
		clickOnElement(getVtigerLeadUpdate.getLeadupdatesave());
		test.log(LogStatus.PASS, "Lead Updated");
	}

	@Test(priority = 7)
	public void VtigerLeadPIMdelete() {
		clickOnElement(getVtigerLeadDelete.getLeads());
		clickOnElement(getVtigerLeadDelete.getDeletelead());
		clickOnElement(getVtigerLeadDelete.getDeleteleadyes());
		expectTitle = "Leads";
		actTitle = getPageTitle(expectTitle);
		Assert.assertEquals(actTitle, expectTitle);
		test.log(LogStatus.PASS, "Lead Deleted");
	}
	@AfterTest
	public void postCondition()
	{
		driver.close();
		report.endTest(test);
		report.flush();
	}

}

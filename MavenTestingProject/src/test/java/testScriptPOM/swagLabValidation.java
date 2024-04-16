package testScriptPOM;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import seleniumUtility.Seleniumutil;
import webPages.swagCheckoutCompletePage;
import webPages.swagCheckoutStepOnePage;
import webPages.swagCheckoutStepTwoPage;
import webPages.swagLabCartPage;
import webPages.swagLabHomePage;
import webPages.swagLabLoginPage;

public class swagLabValidation extends Seleniumutil{
	
	swagLabLoginPage getswagLabLoginPage;
	swagLabHomePage getSwagLabHomePage;
	swagLabCartPage getswagLabCartPage;
	swagCheckoutStepOnePage getswagCheckoutStepOnePage;
	swagCheckoutStepTwoPage getswagCheckoutStepTwoPage;
	swagCheckoutCompletePage getswagCheckoutCompletePage;
	String actualTitle;
	String expectecTitle;
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	public void precondition()
	{	
		driver = setUp("chrome", "https://www.saucedemo.com/");
		getswagLabLoginPage=new swagLabLoginPage(driver);
		getSwagLabHomePage =new swagLabHomePage(driver);
		getswagLabCartPage =new swagLabCartPage(driver);
		getswagCheckoutStepOnePage = new swagCheckoutStepOnePage(driver);
		getswagCheckoutStepTwoPage=new swagCheckoutStepTwoPage(driver);
		getswagCheckoutCompletePage=new swagCheckoutCompletePage(driver);	
		report = new ExtentReports(".\\ExtentReportResultsSwagLab.html");
		test = report.startTest("ExtentDemoSwagLab");
	}
	
	@Test(priority=1)
	public void testLoginLogout()
	{
		typeRequiredText(getswagLabLoginPage.getuserNameInputField(), "standard_user");
		typeRequiredText(getswagLabLoginPage.getpasswordInputField(), "secret_sauce");
		//getSwagLabHomePage.addToCart();
		clickOnElement(getswagLabLoginPage.getloginButton());
		if (driver.getTitle().equals("Swag Labs")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}
	@Test(priority=2)
	public void testcart()
	{
		clickOnElement(getSwagLabHomePage.getaddToCartBackPack());
		clickOnElement(getSwagLabHomePage.getaddToCartBikeLight());
		clickOnElement(getSwagLabHomePage.getshoppingCartButton());
		clickOnElement(getswagLabCartPage.getcheckoutButton());
		String actualTitle=driver.getTitle();
		expectecTitle="Swag Labs";
		Assert.assertTrue(actualTitle.contains(expectecTitle));
		test.log(LogStatus.PASS, "Added to Cart and CheckedOut");
		
	}
	
	@Test(priority=3)
	public void testCheckoutOverview()
	{
		typeRequiredText(getswagCheckoutStepOnePage.getfirstNameInputField(), "Richa");
		typeRequiredText(getswagCheckoutStepOnePage.getlastNameInputField(), "Merlyn");
		typeRequiredText(getswagCheckoutStepOnePage.getpostalCodeInputField(), "431005");
		clickOnElement(getswagCheckoutStepOnePage.getcontinueButton());
		clickOnElement(getswagCheckoutStepTwoPage.getpurchasedItemsSubTotal());
		clickOnElement(getswagCheckoutStepTwoPage.getfinishButton());
		test.log(LogStatus.PASS, "Personal Details filled");
	}
	
	
	@Test(priority=4)
	public void testShoppingOnSwagLab()
	{
		String expMsgAfterSuccessChkout ="Thank you for your order!";
		String actualMsg=getswagCheckoutCompletePage.getSuccessMsg();
		Assert.assertEquals(actualMsg, expMsgAfterSuccessChkout);
		test.log(LogStatus.PASS, "Ordered successfully");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		report.endTest(test);
		report.flush();
	}
	
	

}
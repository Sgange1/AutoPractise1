package windowHandling;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class railAssign extends Seleniumutil {

	@BeforeTest
	public void openBrowser() {
		setUp("chrome", "https://erail.in/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void handleWindows() {

		String homeWinId = driver.getWindowHandle();
		System.out.println("Current Window id: " + homeWinId);
		System.out.println("Home page title: " + driver.getTitle());
		clickOnElement(driver.findElement(By.xpath("//a[text()='eCatering']")));

		Set<String> allWinIds = driver.getWindowHandles();
		System.out.println("All win ids: " + allWinIds);

		allWinIds.remove(homeWinId);
		Iterator<String> itr = allWinIds.iterator();
		String childWinId = itr.next();
		System.out.println("Child window id: " + childWinId);
		driver.switchTo().window(childWinId);

		System.out.println("child window title: " + driver.getTitle());
		clickOnElement(driver.findElement(By.cssSelector("input.form-input.pl-12.pr-4")));
		driver.findElement(By.cssSelector("input.form-input.pl-12.text-sm")).sendKeys("12627");
		clickOnElement(driver.findElement(By.xpath("//button[text()='KARNATAKA EXP']")));

		clickOnElement(
				driver.findElement(By.xpath("//input[@class='form-input custom-date-picker h-11.5 pl-12 text-sm']")));
		WebElement active = driver.switchTo().activeElement();
		active.sendKeys(Keys.chord(Keys.ARROW_DOWN));

		clickOnElement(driver.findElement(By.xpath("//select[@placeholder='Boarding Station']")));
		driver.switchTo().activeElement().sendKeys("i", Keys.ENTER);
		clickOnElement(driver.findElement(By.xpath("//button[@class='btn-primary w-full']")));

		// Click on the "FIND FOOD" button
		driver.findElement(By.xpath("//button[text()='FIND FOOD']")).click();

		List<WebElement> restaurantList = driver.findElements(By.xpath("//h5[@class='tracking-normal ']"));
		System.out.println("Total restaurants : " + restaurantList.size());

		// Printing restaurant List
		System.out.println("Restaurant List is ");
		for (int i = 0; i < restaurantList.size(); i++)
			System.out.println(restaurantList.get(i).getText());

		// Returning to main Window
		driver.switchTo().window(homeWinId);
		System.out.println("Home page title: " + driver.getTitle());

		// Selecting From station
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("Pune", Keys.ENTER);

		// Selecting To station
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("Bengaluru", Keys.ENTER);

		driver.findElement(By.cssSelector(".icon-right-big")).click();

		// Selecting Quota
		WebElement quotaSelect = driver.findElement(By.id("cmbQuota"));
		quotaSelect.click();
		Select Quota = new Select(quotaSelect);
		Quota.selectByVisibleText("General Quota");

		// Select Train type
		WebElement trainType = driver.findElement(By.id("selectTrainType"));
		trainType.click();
		Select train = new Select(trainType);
		train.selectByVisibleText("Humsafar - 2");

		// Select Train Class
		WebElement trainClass = driver.findElement(By.id("selectClassFilter"));
		trainClass.click();
		Select tclass = new Select(trainClass);
		tclass.selectByVisibleText("3A - 3Tier AC");

		driver.findElement(By.id("buttonFromTo")).click();

		List<WebElement> trainList = driver.findElements(By.xpath("//div[@id='divTrainsList']/table/tbody[1]/tr"));

		// Printing menu list
		System.out.println("Train time Table : ");
		for (int i = 0; i < trainList.size(); i++)
			System.out.println(trainList.get(i).getText() + " ");
	}
}
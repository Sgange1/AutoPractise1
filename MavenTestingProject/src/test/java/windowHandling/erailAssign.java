package windowHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

@Test
public class erailAssign extends Seleniumutil {
	@Test
	public void erail() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		String homeId = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='eCatering']")).click();
		Set<String> allWind = driver.getWindowHandles();
		System.out.println("All win ID's: " + allWind);
		// get ecatering window
		allWind.remove(homeId);
		Iterator<String> itr = allWind.iterator();
		String childID = itr.next();
		// move to child tab
		driver.switchTo().window(childID);
		// performing operations
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div/div[2]/input")).sendKeys("12627");
		driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[2]/div/button")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("date")).click();
		driver.findElement(By.name("date")).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER, Keys.TAB,
				Keys.ENTER);
		WebElement station = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div/div[2]/div/div[2]/select"));
		station.click();
		Select stationN = new Select(station);
		stationN.selectByIndex(27);
		driver.findElement(By.xpath("//button[text()='FIND FOOD']")).click();

		List<WebElement> restaurantList = driver.findElements(By.xpath("//h5[@class='tracking-normal ']"));
		System.out.println("Total restaurants : " + restaurantList.size());

		// Printing restaurant List
		System.out.println("Restaurant List is ");
		for (int i = 0; i < restaurantList.size(); i++) {
			restaurantList = driver.findElements(By.xpath("//h5[@class='tracking-normal ']"));
			System.out.println(restaurantList.get(i).getText());
		}
//List<WebElement> list = driver
//		.findElements(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/h5"));
		/*
		 * List<WebElement> list=driver.findElements(By.cssSelector(
		 * ".bg-white>div>div>*:nth-child(2)>div>h5")); for (int i = 0; i < list.size();
		 * i++) { // to avoid StaleElementReferenceException, re-identify suggestionList
		 * list = driver.findElements( By.xpath(
		 * "/html/body/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/h5"));
		 * System.out.println("Res List: " + list.get(i).getText()); }
		 */

		driver.switchTo().window(homeId);
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Pune", Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Bangalore", Keys.ENTER);
		driver.findElement(By.id("tdDateFromTo")).click();
		driver.findElement(By.xpath("/html/body/div[2]/center/table/tbody/tr/td[2]/table/tbody/tr[5]/td[1]")).click();
		driver.findElement(By.id("buttonFromTo")).click();

		List<WebElement> tList = driver
				.findElements(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr/td[1]/a[1]"));
		List<WebElement> tname = driver
				.findElements(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr/td[2]/a[1]"));
		for (int i = 0; i < tList.size(); i++) {
			// to avoid StaleElementReferenceException, re-identify suggestionList
			tList = driver.findElements(
					By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr/td[1]/a[1]"));
			tname = driver.findElements(
					By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr/td[2]/a[1]"));
			System.out.println("Train List: " + tList.get(i).getText());
			System.out.println("Train Name: " + tname.get(i).getText());
		}

	}

}
/*
 * TC5: https://erail.in/ click on eCatering enter train number 12627 date from
 * next month any station (Itarsi) click submit print all resturent names go
 * back home page perform following 1. from: Pune 2. to: Bangalore 3. date from
 * next month 4. click on get trains print all the train numbers and name which
 * are running on that particular date
 * 
 * 
 */
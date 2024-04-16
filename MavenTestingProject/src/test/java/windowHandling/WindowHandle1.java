package windowHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class WindowHandle1 extends Seleniumutil {
	@Test
	public void testWindowHandling() {

		WebDriver driver = setUp("chrome", "https://etrain.info/in");
		// current window unique id
		String homeWinId = driver.getWindowHandle();
		System.out.println("Current Window id: " + homeWinId);
		System.out.println("Home page title: " + driver.getTitle());
		clickOnElement(driver.findElement(By.cssSelector(".icon-twitter")));
		// get all window ids opened after clicking
		Set<String> allWinIds = driver.getWindowHandles();
		System.out.println("All win ids: " + allWinIds);

		// get child window id from allWinIds
		allWinIds.remove(homeWinId);
		Iterator<String> itr = allWinIds.iterator();
		String childWinId = itr.next();
		System.out.println("Child window id: " + childWinId);

		// now we can move to child tab/window
		driver.switchTo().window(childWinId);
		// you have a control on child window, you can perform any required operation on
		// it
		System.out.println("child window title: " + getPageTitle("Log in to X / X"));

		// it will close child window, but control won;t be shifted to parent window
		// automatically
		// driver.close();

		// for parent window again move your control
		driver.switchTo().window(homeWinId);
		System.out.println("Home page title: " + driver.getTitle());

		// it will close parent window
		// driver.close();

		// you want to close all windows in one time
		driver.quit();

	}
}

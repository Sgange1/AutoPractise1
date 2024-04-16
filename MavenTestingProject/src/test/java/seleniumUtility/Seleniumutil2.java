package seleniumUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Seleniumutil2 {
	public static void main(String[] args) throws InterruptedException {
		Seleniumutil util = new Seleniumutil();
		WebDriver driver = util.setUp("chrome", "https://jqueryui.com/droppable/");

		// to get inside the frame use below statement
		driver.switchTo().frame(0);

		// to perform drag and drop first identify source and target
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		util.performDragAndDrop(src, target);
	}

}
/*
 * Open actitime application enter user name as admin01 copy it and paste it
 * into password field press enter button to login
 */
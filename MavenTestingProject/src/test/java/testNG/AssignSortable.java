package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class AssignSortable extends Seleniumutil{
  @Test
  public void sortableFrame() throws InterruptedException {
	  WebDriver driver = setUp("chrome", "https://jqueryui.com/");
	 driver.switchTo().frame(0);
	 List<WebElement> itemList=driver.findElements(By.cssSelector("#sortable>li"));
	 for(int i=0; i<itemList.size()-1; i++) {
		 itemList=driver.findElements(By.cssSelector("#sortable>li"));
		 action.dragAndDrop(itemList.get(itemList.size()-1), itemList.get(i)).build().perform();
		 Thread.sleep(2000);
	 }
	  
	 
  }
}

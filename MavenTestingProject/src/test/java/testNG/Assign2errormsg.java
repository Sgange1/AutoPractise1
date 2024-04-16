package testNG;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumUtility.Seleniumutil;

public class Assign2errormsg extends Seleniumutil{
  @Test
  public void errorMsg() {
	  WebDriver driver = setUp("chrome", "https://www.rakuten.com/");
	  driver.findElement(By.id("header_sign_in")).click();
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("/html/body/div/div/form/div/div[1]/div[1]/input")).sendKeys("abc@gmail.com");
	  driver.findElement(By.xpath("/html/body/div/div/form/div/div[2]/div[1]/input")).sendKeys("abcd@1234");
	  driver.findElement(By.id("email-auth-btn")).click();
	  WebElement errorM=driver.findElement(By.xpath("//div[text()='Captcha validation is required.']"));
	  //error msg
	 //	error msg color
	 	//error msg background color*/
	  System.out.println("Error msg: " +errorM);
	  System.out.println("Error msg color: "+errorM.getCssValue("color"));
		System.out.println("Error msg font-size: "+errorM.getCssValue("background"));
	  
  }
}
/*Open any browser and enter url as https://www.rakuten.com/
 click on signin link enter username as abc@gmail.com
 enter password as abcd@1234
 click on SignIn button
 validate:
 	error msg
 	error msg color
 	error msg background color*/
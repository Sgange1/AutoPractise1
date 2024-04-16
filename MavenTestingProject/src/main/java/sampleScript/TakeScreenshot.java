package sampleScript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		Seleniumutil util=new Seleniumutil();
		WebDriver driver=util.setUp("chrome", "https://www.google.com");
		//type cast WebDriver instance into TakeScreenshot interface
		TakesScreenshot ts=(TakesScreenshot) driver;
		//take screenshot in the form of File object
		File screenShot=ts.getScreenshotAs(OutputType.FILE);
		//store screenshot into required location
		FileUtils.copyFile(screenShot, new File(".\\\\Screenshots\\\\google.jpg"));
		System.out.println("Screenshot is taken");

	}

}

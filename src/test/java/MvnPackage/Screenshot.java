package MvnPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {
	
	@Test
	public void demo() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("Screenshots\\screenshot1.jpg"));
		
		driver.findElement(By.linkText("compendiumdev")).click();
		
		File screenshot2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot2, new File("Screenshots\\screenshot2.jpg"));
	}

}

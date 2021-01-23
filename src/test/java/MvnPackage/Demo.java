package MvnPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//This is class Demo

public class Demo {
	
	ExtentReports eRep;
	ExtentTest eTest;
	
	@Test
	public void MethodA()
	{
		eRep=ExtentManager.getInstance();
		eTest=eRep.startTest("Test Omayo");
		eTest.log(LogStatus.INFO, "Test Omayo report capture starts here");
		
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		eTest.log(LogStatus.INFO, "Chrome Bowser has been Opened");
	
		driver.manage().window().maximize();
		eTest.log(LogStatus.INFO, "Chrome Bowser has been Maximized");

		
		driver.get("https://omayo.blogspot.com");
		eTest.log(LogStatus.INFO, "Omayo Blogspot URL has been Opened");

		
		String expectedtext="PracticeAutomationHerexyz";
		
		String actualtext=driver.findElement(By.id("pah")).getText();
		
		if(actualtext.equalsIgnoreCase(expectedtext))
		{
			System.out.println("The string is matched");
			eTest.log(LogStatus.PASS, "String  Cases is matched");

		}
		
		else
		{
			
			System.out.println("The string is NOT matched");
			eTest.log(LogStatus.FAIL, "String  Cases is NOT matched");
			Assert.fail("Assert Fail for TestNG report");

	
		}
		driver.close();
	}
	
	@AfterMethod
	public void clean()
	{
		eRep.endTest(eTest);
		eRep.flush();
	}
	

}

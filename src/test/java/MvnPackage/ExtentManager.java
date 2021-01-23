package MvnPackage;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

//This is a comment in Extent Manager
public class ExtentManager {
	
	@Test
	public static ExtentReports getInstance()
	{
	
	Date date=new Date();
	
	String filenameType=date.toString().replace(" ", "_").replace(":", "_")+ ".html";
	
	String filePath="reports\\"+filenameType;
	
	ExtentReports eReport=new ExtentReports(filePath, true, DisplayOrder.NEWEST_FIRST);
	
	File configFile=new File("ReportsConfig.xml");
	
	eReport.loadConfig(configFile); 
	
	eReport.addSystemInfo("TestNG", "7.1.0").addSystemInfo("Selenium", "3.141.59")
	.addSystemInfo("Envi", "Staging").addSystemInfo("ExecutedBy", "Satvik");
	
	return eReport;
	
	}
	
	

}

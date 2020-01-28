package Rough;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReportDemo {
	
	

	public static void main(String[] args) {
		
		//dd-MM-yyyy-HH.mm.ss
		
		String path = System.getProperty("user.dir");
		
		System.out.println(path);
		
		String dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new Date());
		
		System.out.println(dateFormat);
		
		ExtentHtmlReporter report = new ExtentHtmlReporter(path+"\\Report\\TestReport_"+dateFormat+".html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(report);
		
		ExtentTest logger = extent.createTest("Login Test");

		
		logger.log(Status.PASS, "Test Passed");
		logger.log(Status.ERROR, "Test Error");
		logger.log(Status.INFO, "Just Info");
		logger.log(Status.FAIL, "Test Fail");
		
		extent.flush();
		
		
		
		
		


		
	}

}

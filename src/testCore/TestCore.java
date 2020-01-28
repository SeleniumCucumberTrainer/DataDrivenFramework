package testCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.Xls_Reader;

public class TestCore {
	
	public WebDriver driver;
	public utility.Xls_Reader excel;
	
	public ExtentTest logger;
	public ExtentReports extent;
	
	public Properties config = new Properties();
	public Properties Object = new Properties();
	

	@BeforeTest
	public void init() throws IOException{
		
        String path = System.getProperty("user.dir");
		
		System.out.println(path);
		
		String dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new Date());
		
		System.out.println(dateFormat);
		
		ExtentHtmlReporter report = new ExtentHtmlReporter(path+"\\Report\\TestReport_"+dateFormat+".html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(report);
		
		logger = extent.createTest("Login Test");
		
		FileInputStream fisConfig = new FileInputStream(new File(path+"\\src\\objectRepo\\Config.properties"));
		
		config.load(fisConfig);
		
		FileInputStream fisObject = new FileInputStream(new File(path+"\\src\\objectRepo\\Object.properties"));
		
		Object.load(fisObject);
		
     excel= new Xls_Reader(path+"\\Data\\testData.xlsx");
     
     System.setProperty("webdriver.gecko.driver", "C:\\Jar\\driver\\geckodriver.exe");
	 
	 driver = new FirefoxDriver();
	 
	 driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     
     String gmailUrl = config.getProperty("url");
     
     driver.get(gmailUrl);
     
	}
	
	@AfterTest
	public void tearDown(){
		
		extent.flush();
		
		//driver.quit();
		
	}

}

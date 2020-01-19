package testCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import utility.Xls_Reader;

public class TestCore {
	
	public WebDriver driver;
	public utility.Xls_Reader excel;
	
	public Properties config = new Properties();
	public Properties Object = new Properties();
	
	
	@BeforeTest
	public void init() throws IOException{
		
	    String path  = System.getProperty("user.dir");
	    
	    System.out.println(path);
		
		FileInputStream fisConfig = new FileInputStream(new File(path+"\\DataDrivenFramework\\src\\objectRepo\\Config.properties"));
		
		config.load(fisConfig);
		
		FileInputStream fisObject = new FileInputStream(new File(path+"\\DataDrivenFramework\\src\\objectRepo\\Object.properties"));
		
		Object.load(fisObject);
		
     excel= new Xls_Reader(path+"\\SeleniumDemo\\Data\\testData.xlsx");
     
     System.setProperty("webdriver.gecko.driver", "C:\\Jar\\driver\\geckodriver.exe");
	 
	 driver = new FirefoxDriver();
	 
	 driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     
     String gmailUrl = config.getProperty("url");
     
     driver.get(gmailUrl);
	 
	 
	
	
	}

}

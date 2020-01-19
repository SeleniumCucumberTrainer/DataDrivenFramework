package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import testCore.TestCore;

public class GmailLogin extends TestCore{
	
	
	
	@Test(priority=1)
	public void doLogin(){
		 
		 String emailXapth = Object.getProperty("emailId");
		    
	        driver.findElement(By.xpath(emailXapth)).sendKeys("akhilesh");
		
	}

	
	@Test(priority=2)
	public void doLogout(){
		 
		    
	        driver.quit();
		
	}

}

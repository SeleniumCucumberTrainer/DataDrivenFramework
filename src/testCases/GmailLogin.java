package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.LoginPage;
import testCore.TestCore;

public class GmailLogin extends TestCore{
	
	
	
	@Test(priority=1)
	public void doLogin() throws IOException{
		 
		
		  
	    
	        driver.findElement(By.xpath(Object.getProperty("emailId"))).sendKeys("akhileshg50@gmail.com");
	        
	        log.debug("entering email Id");
	        
	        driver.findElement(By.xpath(Object.getProperty("nextButton"))).click();
	        
	        log.debug("Clicking on next button");
	        
	        driver.findElement(By.xpath(Object.getProperty("pass"))).sendKeys("akhileshg50");
	        
	        log.debug("Entering password");
	        
	        driver.findElement(By.xpath(Object.getProperty("nextButton"))).click();
	        
	        log.debug("Clicking on Login");
	        
	        try{
	       
	        
	        driver.findElement(By.xpath(Object.getProperty("InvalidPassword")));
	        
	        logger.log(Status.PASS, "Test is passes");
	        
	        log.debug("Test case pass");
	        
	        }
	        catch(Exception t){
	        	
	        	logger.addScreenCaptureFromPath("path");
	        	
	        	 logger.log(Status.FAIL, "Test is failed");
	        	 
	        	 log.debug("Test case failed");
	        	
	        }
	        
	        
	        
	        
	        
	       
	}
	
	//@Test(priority=1)
	public void doTitleTest() throws IOException{
		 
	    
	      String title = driver.getTitle();
	      
	      if(title.equals("Gmail")){
	    	  
	    	  logger.log(Status.PASS, "Test is passes");
	    	  
	      }
	      
	      
	        
	        
	       
	}



}

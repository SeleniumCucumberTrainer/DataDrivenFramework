package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testCore.TestCore;

public class GmailLogin extends TestCore{
	
	
	
	@Test(priority=1)
	public void doLogin() throws IOException{
		 
	    
	        driver.findElement(By.xpath(Object.getProperty("emailId"))).sendKeys("akhileshg50@gmail.com");
	        
	        driver.findElement(By.xpath(Object.getProperty("nextButton"))).click();
	        
	        driver.findElement(By.xpath(Object.getProperty("pass"))).sendKeys("akhileshg50");
	        
	        driver.findElement(By.xpath(Object.getProperty("nextButton"))).click();
	        
	        try{
	       
	        
	        driver.findElement(By.xpath(Object.getProperty("InvalidPassword")));
	        
	        logger.log(Status.PASS, "Test is passes");
	        
	        }
	        catch(Exception t){
	        	
	        	logger.addScreenCaptureFromPath("path");
	        	
	        	 logger.log(Status.FAIL, "Test is failed");
	        	
	        }
	        
	        
	        
	        
	        
	       
	}
	
	@Test(priority=1)
	public void doTitleTest() throws IOException{
		 
	    
	      String title = driver.getTitle();
	      
	      if(title.equals("Gmail")){
	    	  
	    	  logger.log(Status.PASS, "Test is passes");
	    	  
	      }
	      
	      
	        
	        
	       
	}



}

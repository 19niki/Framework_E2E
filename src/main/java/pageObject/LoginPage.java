package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage 
{
	public WebDriver driver;
	  
    By username=By.id("user_email");
    By password=By.id("user_password");
    By submit = By.name("commit");
  
    public LoginPage(WebDriver driver) {
    	this.driver=driver;
    }
  
   
    public void getusername(String user)
    {
    	driver.findElement(username).sendKeys(user);
    }
    
    public void getpassword(String pass) {
       driver.findElement(password).sendKeys(pass);	
    }
   
    public void getsubmit() {
    	driver.findElement(submit).click();
    }
    
    
    
   }
	  

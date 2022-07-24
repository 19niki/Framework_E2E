package pageObject;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage 
{
  public WebDriver driver;
  
    By Login=By.xpath("//a/span[text()='Login']");
    By popup = By.xpath("//button[text()='NO THANKS']");
    By navbar = By.xpath("//ul[@class = 'nav navbar-nav navbar-right']");
    
    
    
    public LandingPage(WebDriver driver) {
    	this.driver=driver;
    }
    
    public void removepopup() {
    	List<WebElement> popups=driver.findElements(popup);
    	if(popups.size()>0)
    	{
    		driver.findElement(popup).click();
    	}
    }
    
    public void validatenav()
    {
        Assert.assertTrue(driver.findElement(navbar).isDisplayed());
   
    }
    
    public void getLogin()
    {
    	
    	WebElement login_Click = driver.findElement(Login);
    	login_Click.click();
    
    }
}

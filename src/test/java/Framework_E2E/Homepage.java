package Framework_E2E;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class Homepage extends Base
{
	
	@BeforeTest
	public void intliaze() throws Exception {
		driver = invokeBrowser();
	
	}
	
   @Test (dataProvider ="getData")
   public void baseNavigation(String username, String password) throws Exception 
   {
	   /*
	   Base obj = new Base();
	 WebDriver  driver = obj.invokeBrowser();
	 */
	   driver.get(url_name);
	  LandingPage l= new LandingPage(driver);
	  l.removepopup();
	  l.getLogin();
	  LoginPage lo = new LoginPage(driver);
	  lo.getusername(username);
	  lo.getpassword(password);
	  lo.getsubmit();
   }
   
   
	  @DataProvider
	  public Object[][] getData()
	  { 
	  	Object [][] data = new Object[2][2];
	      data [0][0] = "nikhilravi9847@gmail.com";
	      data [0][1] = "test1234";
	      
	      data [1][0] = "akhilravi9847@gmail.com";
	      data [1][1] = "test1234";
	  	return data;
	  }
	  
	  @AfterTest
		public void teardown() {
			driver.close();
		}
	   
   }


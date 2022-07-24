package Framework_E2E;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class Validate_NavBar extends Base {

	
	@BeforeTest
	public void intliaze() throws Exception {
		driver = invokeBrowser();
	
	}
	
	@Test
	public void navbar() throws Exception 
	{
		LandingPage l = new LandingPage(driver);
		l.removepopup();
		l.validatenav();		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}

package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	public WebDriver driver;
	Properties pro;
	public String url_name;

	public WebDriver invokeBrowser() throws Exception
	{
		//this.driver=driver;
		
		pro = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Software\\Eclipse\\workspace\\Framework_E2E\\src\\main\\java\\resources\\Document.Properties");
		pro.load(fis);
		/*
		 * To select the browser during the run time we can use below command
		 * mvn -dbrowser=chrome		
		 * and use the sytem.getProperty("browser")
		 * 
		 */
		
		
		String browser_name = System.getProperty("browser");
	    //String browser_name= pro.getProperty("browser");
	    url_name = pro.getProperty("url");
	    System.out.println(browser_name);
	    
		if(browser_name.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Software\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();	
			  driver.get(url_name);
		}
		else if(browser_name.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","E:\\Software\\Selenium\\msedgedriver.exe");
			driver = new EdgeDriver();	
			driver.get(url_name);
		}
		else if(browser_name.equalsIgnoreCase("Firefox"))
		{
			
		}
	
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
 		driver.manage().window().maximize();
        return driver;		
	}
	
 public void screenshot(String methodname, WebDriver driver) throws IOException
 {
	 
     File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     String resource = System.getProperty("User.dir")+"\\Reports\\"+methodname+".png";
     File dest = new File(resource);
     FileUtils.copyFile(src, dest);
 }
}
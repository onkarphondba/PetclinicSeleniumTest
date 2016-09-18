package Sample;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PetClinicTest {

 private RemoteWebDriver  driver;
	

  @BeforeTest
   public void beforeTest() throws MalformedURLException {
 
 	//System.setProperty("webdriver.chrome.driver", "//var//jenkins_home//workspace//seleniumT//chromedriver"); 
	//driver = new ChromeDriver();
	
   //setup with gecko driver
   //System.setProperty("webdriver.gecko.driver", "C:\\Tools\\chromedriver.exe");   
   //System.setProperty("webdriver.gecko.driver", "/var/lib/jenkins/workspace/Petclininc/geckodriver"); 
   


      
  //setup with seleniium Grid
  DesiredCapabilities capability = DesiredCapabilities.firefox();  
  driver = new RemoteWebDriver(new URL("http://172.17.0.1:4445//wd/hub"), capability);
  /*
  DesiredCapabilities capability = DesiredCapabilities.chrome();	
  driver = new RemoteWebDriver(new URL("http://172.31.32.160:4444//wd/hub"), capability);
   */
   }
  
	@Test
  public void testEasy() 
  
  {   
		System.out.println("Navigating to petclinic"); 
		driver.get("http://192.168.1.100:8082/petclinic/");
		//driver.manage().window().maximize();	
		
		
	  	String title = driver.getTitle();   
        System.out.println("Home Page Header : "+title);
    
           
        
        System.out.println("adding owner and pet");
		driver.findElement(By.xpath("//nav//ul/li[2]/a")).click();
		driver.findElement(By.xpath("//div//a[contains(text(),'Add Owner')]")).click();
		driver.findElement(By.id("firstName")).sendKeys("abc");
		driver.findElement(By.id("lastName")).sendKeys("def");
		driver.findElement(By.id("address")).sendKeys("99th Street");
		driver.findElement(By.id("city")).sendKeys("Mumbai");
		driver.findElement(By.id("telephone")).sendKeys("4567891230");
		driver.findElement(By.xpath("//div[@class='col-sm-offset-2 col-sm-10']/button")).click();
		driver.findElement(By.xpath("//div[@class='container xd-container']/a[2]")).click();
		driver.findElement(By.id("name")).sendKeys("Ghost");
		driver.findElement(By.id("birthDate")).sendKeys("2015/05/05");
		driver.findElement(By.xpath("//div[@class='container-fluid']")).click();
		//Select select=new Select(driver.findElement(By.id("type")));
		//select.selectByVisibleText("dog");
		
		//driver.findElement(By.xpath("//form//div/button[@class='btn btn-default']")).click();
       
		
	  	
    }

  @AfterTest
  public void afterTest() {
  driver.close();   
  }
}
  

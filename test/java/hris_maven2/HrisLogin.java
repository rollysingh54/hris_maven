package hris_maven2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HrisLogin {

//	WebElement username;
//	WebElement password;
 	 WebDriver driver;
 	 
  public HrisLogin(WebDriver wbdriver)
  {
	  System.out.println("In hrisLogin costructor");
	  this.driver=wbdriver;
	  System.out.println("driver   -    "+driver);
  }
  
		
  private WebElement getUsernameEntry()
  {
	  return this.driver.findElement(By.id("txtUserName"));
  }
  
//  private WebElement getUsernameEntryThroughCSS() throws InterruptedException
//  {
//	  WebElement el = driver.findElement(By.cssSelector("input[name=\"txtUserName\"]"));
//	  System.out.println(el+"\n"+el.isDisplayed());
////	  return driver.findElement(By.cssSelector("input#txtUserName"));
//	  return el;
//  }
//  
  private WebElement getPasswordEntry()
  {
	  return this.driver.findElement(By.id("txtPassword"));
  }	
  private WebElement getErrorMessageElement()
  {
      return this.driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]"));
  }
  
  public void getUrl() {
		driver.manage().window().maximize();
		driver.get("https://hris.qainfotech.com/login.php");
		String expectedUrl="https://hris.qainfotech.com/login.php";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"Wrong or Incorrect URL !!");
		


	}


	public void getLoginPanelLink() {
		driver.findElement(By.cssSelector("a[href=\"#panel1\"]")).click();
		
	}

	private void login(String username, String password)
	{
		
		getUsernameEntry().clear();
		getUsernameEntry().sendKeys(username);
//		getUsernameEntryThroughCSS().click();
//		getUsernameEntryThroughCSS().sendKeys(username);
		getPasswordEntry().clear();
		getPasswordEntry().sendKeys(password);
		getPasswordEntry().submit();
   }
	
	public  String loginWithIncorrectCredentials(String username, String password) 
	{
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login(username, password);
        return getErrorMessageElement().getText();
	
	}
	
	public void loginWithCorrectCredentials(String username, String password) 
	{
		
		login(username, password);
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		 webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class^='icon_size time']")));
		driver.findElement(By.cssSelector("span[class^='icon_size time']")).click();
		String expectedUrl="https://hris.qainfotech.com:8086/time/timesheet";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"Unable to login due to wrong url path !!");
	}
	
}

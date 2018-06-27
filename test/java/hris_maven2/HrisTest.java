package hris_maven2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HrisTest {
	public static WebDriver webdriver;
	HrisLogin loginform ;
	HrisLogout logoutObject;
	TimeSheet timesheetObject;
 
  @BeforeTest
  public void launchDriver() {
	  webdriver= new ChromeDriver();
	  loginform  = new HrisLogin(webdriver);
	  logoutObject=new HrisLogout(webdriver);
	  timesheetObject=new TimeSheet(webdriver);
  }
  
  @Test(priority=0)
  public void launchUrl()
  {
	  //webdriver.get("https://hris.qainfotech.com");
	  loginform.getUrl();
  }
  
  @Test(priority=1)
  public void clickLoginPanelLink()
  {
	  //webdriver.findElement(By.cssSelector("a[href=\"#panel1\"]")).click();
	  loginform.getLoginPanelLink();
  }
  
//  @Test(priority=2)
//  public void incorrectLogin() 
//  {
//	  
//	  Assert.assertTrue(loginform.loginWithIncorrectCredentials("rollysingh", "fvhghgj").contains("Invalid Login")); 
//	  //loginform.loginWithIncorrectCredentials("rollysingh", "fvhghgj").contains("Invalid Login");
//  }
  
  
  @Test(priority=3)
  public void correctLogin() 
  {
	  loginform.loginWithCorrectCredentials("rollysingh", "Rolly@321#");
  }
  @Test(priority=4)
  public void accessTimesheet() throws InterruptedException 
  {
	 timesheetObject.timesheet();
  }
  @Test(priority=5)
  public void logoutAfterAccessingTimeSheet() throws InterruptedException 
  {
	 logoutObject.logout();
  }

//  @AfterTest
//  public void afterTest()
//  {
//	   driver.quit();
//
//  }
  

}

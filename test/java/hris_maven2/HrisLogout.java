package hris_maven2;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HrisLogout {
	
	 WebDriver driver;
 	 
	  public HrisLogout(WebDriver wbdriver)
	  {
		  this.driver=wbdriver;
	  }
	  
   
	public void logout() throws InterruptedException 
	{
	 WebElement profileElement=	driver.findElement(By.className("profile-btn"));
	 //System.out.println("profile link btn is displayed-  "+profileElement.isDisplayed());
	 Thread.sleep(3000);
	 profileElement.click();
	 
	 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
	 webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class*='user-profile-option1']")));
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//span[text()='Logout']")).click();
	 System.out.println("Logout successfully");

	}

}

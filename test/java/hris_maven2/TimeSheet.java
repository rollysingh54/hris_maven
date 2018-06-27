package hris_maven2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeSheet {

	
	WebDriver driver;
	 
	
 
	public TimeSheet(WebDriver webdriver) {
		// TODO Auto-generated constructor stub
		this.driver=webdriver;
	}


	public void timesheet() throws InterruptedException 
	{
	 WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
	 webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dv_2018-06-11\"]/div/div[1]/div")));
	 driver.findElement(By.xpath("//div[@class='td_cell']/span[text()='11']")).click();
	 Thread.sleep(4000);
	 driver.findElement(By.xpath("//*[@id=\"tag-me\"]/div/div/div[1]/button/span")).click();//cross-sign of modal box
	
	}

}

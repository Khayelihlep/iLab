package SeleniumWebdriver;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;	
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Apply 
{
	
	
	@Test
	public void testAtomation()
	{
		System.setProperty("webdriver.ie.driver","C:\\Workspace Eclipse\\Khanyi\\vv\\IEDriverServer.exe");

		WebDriver driver = new InternetExplorerDriver();

		driver.get( "https://www.ilabquality.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("CAREERS")).click();
		driver.findElement(By.xpath("//a[contains(.,'South Africa')]")).click();
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/span[1]/a")).click();
		driver.findElement(By.xpath("//a[contains(.,'Apply Online')]")).click();
		driver.findElement(By.id("applicant_name")).sendKeys("Khayelihle Kunene");
		driver.findElement(By.id("email")).sendKeys("automationAssessment@iLABQuality.com");

		String phone = String.format("083"+" %03d %04d",(int) Math.floor(999*Math.random()),(int) Math.floor(9999*Math.random()));
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.id("wpjb_submit")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String expectedMessage= "You need to upload at least one file.";

		String actualMessage = driver.findElement(By.className("wpjb-errors")).getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage));



		driver.close();
	}

}

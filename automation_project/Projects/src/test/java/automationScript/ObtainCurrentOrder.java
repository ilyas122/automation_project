package automationScript;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObtainCurrentOrder {
	
	WebDriver driver;
	String URL = "https://demo.opencart.com/admin/index.php";
	
	@Before
	public void Initialize() {
		driver = new ChromeDriver();
		driver.navigate().to(URL);
	}
	
	@Test
	public void TestRun() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElement(By.xpath(" //input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		//WebElement submit = driver.findElement(By.className("btn btn-primary"));
		submit.click();		
		
		Thread.sleep(2000);
       
		try {
			WebElement TotalOrders = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]"));
			String verifyorders = TotalOrders.getText();
	        LocalDateTime currentDate = LocalDateTime.now();
	        
	        // Format the date as a string (optional)
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDate = currentDate.format(formatter);
	        
	        System.out.println("Current order as of "+formattedDate+" is "+verifyorders);
	        
	        
			
						
		}catch (Exception e) {
			System.out.println("Elements could not be loaded. Please execute test case again!");
		}
		
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}
	


}

package WebDriver_Methods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException 
	{
		// Approach 01
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//a[normalize-space()='Books']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Computers']")).click();
		
		Set<String> windowsIDs=driver.getWindowHandles();
		
		//Apporach01
		List<String> windowList=new ArrayList(windowsIDs);
		String parentID = driver.getWindowHandle();
		
		for (String winID : windowsIDs) {
		    if (!winID.equals(parentID)) {
		        driver.switchTo().window(winID);
		    }
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}

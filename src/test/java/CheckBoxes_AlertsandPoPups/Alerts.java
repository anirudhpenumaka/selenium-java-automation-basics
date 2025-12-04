package CheckBoxes_AlertsandPoPups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		//Normal Alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Alert myalert=driver.switchTo().alert();
		myalert.accept();
		
		//Confirmation Alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert myalert01=driver.switchTo().alert();
		myalert01.accept();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert myalert02=driver.switchTo().alert();
		myalert02.dismiss();
		Thread.sleep(3000);
		
		//Click for JS Prompt
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert myalert03=driver.switchTo().alert();
		myalert03.sendKeys("Accepted");
		myalert03.accept();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert myalert04=driver.switchTo().alert();
		myalert04.sendKeys("Not Accepted");
		myalert04.dismiss();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}

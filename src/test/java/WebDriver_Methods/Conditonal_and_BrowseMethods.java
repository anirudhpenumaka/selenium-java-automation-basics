package WebDriver_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conditonal_and_BrowseMethods 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//get(URL)
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//isDisplayed, isSelected, IsEnabled
		
		driver.findElement(By.xpath("//input[@id='male']")).click();
		Boolean enablestatus=driver.findElement(By.xpath("//input[@id='male']")).isEnabled();
		Boolean displaystatus=driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']")).isDisplayed();
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		Boolean select=driver.findElement(By.xpath("//input[@id='sunday']")).isSelected();
		
		System.out.println(enablestatus);
		System.out.println(displaystatus);
		System.out.println(select);
		
		Thread.sleep(3000);
		
		//Browse Methods
		driver.close();
		driver.quit();
	}
}

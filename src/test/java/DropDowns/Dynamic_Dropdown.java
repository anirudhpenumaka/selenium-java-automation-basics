package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Dropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/?zx=1764936435205&no_sw_cr=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		 Thread.sleep(2000);
		 
		List<WebElement> list=driver.findElements(By.xpath("//div[@role='option']"));
		System.out.println(list.size());
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).getText());
			//selectSuggestion(driver, "Selenium", "selenium webdriver");
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}

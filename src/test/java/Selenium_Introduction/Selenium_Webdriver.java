package Selenium_Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Webdriver 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in/");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		Thread.sleep(3000);
		driver.quit();

	}

}

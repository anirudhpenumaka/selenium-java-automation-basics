package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in/");
		
		//By id
		Boolean status=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
		System.out.println(status);
		
		//By LinkText
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//Link Text
		driver.findElement(By.linkText("Fashion")).click();
		Thread.sleep(3000);
		
		//Partial Link Text
		driver.findElement(By.partialLinkText("Mobi")).click();
		
		//By Tag name
		int a=driver.findElements(By.tagName("input")).size();
		System.out.println(a);
		
		Thread.sleep(3000);
		driver.quit();

	}

}

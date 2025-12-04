package Absolute_Relative_xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Relative_XPath {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in/");
		
		//Relative Xpath Syntax --> //tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("Photos");
		
		//single attribute
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		//with text
		driver.findElement(By.xpath("//a[text()='Home & Kitchen']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).clear();
		
		//Multiple Attributes
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in'][@role='searchbox']")).sendKeys("Photos");
		
		driver.findElement(By.xpath("//input[contains(@aria-label,'Amazon')]")).click();
		
		//and or operators
		driver.findElement(By.xpath("//input[@type='submit' and value='Go']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in'][@role='searchbox']")).sendKeys("Pictures");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button' or value='Go']")).click();
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}

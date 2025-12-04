package Absolute_Relative_xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxes {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in/");
		
		//Parent label --> xpath/parent::input
		//Parent label --> xpath/parent::
		//Parent label --> xpath/parent::*
		Boolean Bookstatus=	driver.findElement(By.xpath("//a[contains(text(),'Books')]/parent::div")).isDisplayed();
		System.out.println(Bookstatus);
		
		//Child Element
		Boolean childstatus=driver.findElement(By.xpath("//div[@class='nav-div']/a[text()=' Electronics ']")).isDisplayed();
		System.out.println(childstatus);
		
		//grandchildren
		Boolean grandchildren=driver.findElement(By.xpath("//li[@class='nav-li']/div/a//span[text()='Fresh']")).isDisplayed();
		System.out.println(grandchildren);
		
		//Ancestor element
		Boolean ancestor=driver.findElement(By.xpath("//a[text()='New Releases']/ancestor::li")).isDisplayed();
		System.out.println(ancestor);
		
		Thread.sleep(3000);
		driver.quit();

	}

}

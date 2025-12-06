package Sliders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider2 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/?utm_source=chatgpt.com");
		driver.manage().window().maximize();
		
		
		//driver.findElement(By.xpath("//li[@id='Range']")).click();
		
		//WebElement frame = driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]"));
      //  driver.switchTo().frame(frame);
        
		 // Locate handles - DO NOT use style attribute
		WebElement minHandle = driver.findElement(By.xpath("//span[@style='left: 15%;']"));
        WebElement maxHandle = driver.findElement(By.xpath("//span[@style='left: 60%;']"));
        
        System.out.println(minHandle.getLocation());
        System.out.println(maxHandle.getLocation());
        
        Actions act=new Actions(driver);
        act.dragAndDropBy(minHandle, 100, 0).perform();
        act.dragAndDropBy(maxHandle, -90, 0).perform();
        
		Thread.sleep(3000);
		driver.quit();
		
	}

}

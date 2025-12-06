package Sliders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/sliders/?utm_source=chatgpt.com#Color%20Picker");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//li[@id='Range']")).click();
		
		//WebElement frame = driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]"));
      //  driver.switchTo().frame(frame);
        
		 // Locate handles - DO NOT use style attribute
		////span[contains(@class,'ui-slider-handles)'][1]
        WebElement minHandle = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][1]"));
        WebElement maxHandle = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][2]"));
        
        Actions act=new Actions(driver);
        act.dragAndDropBy(minHandle, 100, 0).perform();
        act.dragAndDropBy(maxHandle, -90, 0).perform();
        
		Thread.sleep(3000);
		driver.quit();
		
	}

}

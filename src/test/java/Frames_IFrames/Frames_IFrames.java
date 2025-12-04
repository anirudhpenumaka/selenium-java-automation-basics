package Frames_IFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_IFrames {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		//Frame01
		WebElement Frame01=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(Frame01);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Frame 01");
		driver.switchTo().defaultContent();
		
		//Frame02
		WebElement Frame02=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(Frame02);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Frame 02");
		driver.switchTo().defaultContent();
		
		//Frame02
		WebElement Frame03=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(Frame03);
		// Switch into the inner iFrame
		driver.switchTo().frame(0);

		// Now interact with Google form elements inside nested iframe
		driver.findElement(By.xpath("//div[@class='AB7Lab Id5V1']")).click();  // Web Testing checkbox
		//driver.findElement(By.xpath("//div[@jscontroller]")).click();         // Another element

		// Return to main content
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}

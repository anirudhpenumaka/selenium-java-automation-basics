package ScreenShots;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Capture_SS_from_Specific_Section {

	public static void main(String[] args) throws InterruptedException{

		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		//Specific Section
		WebElement featured_section=driver.findElement(By.xpath("//div[@id='HTML12']"));
		File sourcefile=featured_section.getScreenshotAs(OutputType.FILE);
		File targetfile=new File("C:\\Java Workspace\\Selenium_Basics\\src\\test\\java\\ScreenShots\\specificsection.png");
		//File targetfile = new File(System.getProperty("user.dir") + "\\ScreenShots\\fullpage.png");;
		
		sourcefile.renameTo(targetfile);
		System.out.println(targetfile.getAbsolutePath());
		
		Thread.sleep(3000);
		driver.quit();

	}

}

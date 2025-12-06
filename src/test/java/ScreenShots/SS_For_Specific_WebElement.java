package ScreenShots;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SS_For_Specific_WebElement {

	public static void main(String[] args) throws InterruptedException{

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		//Specific Element
		WebElement specific_element=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		File sourcefile=specific_element.getScreenshotAs(OutputType.FILE);
		File targetfile=new File("C:\\Java Workspace\\Selenium_Basics\\src\\test\\java\\ScreenShots\\specific_element.png");
		//File targetfile = new File(System.getProperty("user.dir") + "\\ScreenShots\\specific_element.png");;
				
		sourcefile.renameTo(targetfile);
		System.out.println(targetfile.getAbsolutePath());
		
		Thread.sleep(3000);
		driver.quit();

	}

}

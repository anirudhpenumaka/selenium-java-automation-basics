package ScreenShots;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Full_Page_Screenshot {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		
		//Full page
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File("C:\\Java Workspace\\Selenium_Basics\\src\\test\\java\\ScreenShots\\fullpage.png");
		//File targetfile = new File(System.getProperty("user.dir") + "\\ScreenShots\\fullpage.png");;
		
		sourcefile.renameTo(targetfile);
		System.out.println(targetfile.getAbsolutePath());
		
		Thread.sleep(3000);
		driver.quit();

	}

}

package WebDriver_Methods;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCommands {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//wait commands
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("FirstName");
		
		//explicit wait
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(3));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xyz@574gmail.com");
		
		mywait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']"))
				).sendKeys("Admin");
		
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(30))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver)
			{
				return driver.findElement(By.xpath("//input[@id='name']"));
			}
		});
		
	}

}

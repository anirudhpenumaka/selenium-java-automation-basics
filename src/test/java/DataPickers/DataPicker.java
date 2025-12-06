package DataPickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataPicker {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Method 01
		/*
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).sendKeys("10/01/1999");
		driver.findElement(By.id("datepicker")).clear();
		driver.switchTo().defaultContent();
		*/
		
		//Method02
		String year="2023";
		String month="April";
		String date="26";
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		
		while(true) {
		
		String current_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String current_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
		if(current_month.equals(month) && current_year.equals(year))
		{
			break;
		}
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //future
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //past
		}
		
		//now date selection
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td/a"));
		for(WebElement required_date:alldates)
		{
			if(required_date.getText().equals(date))
			{
				required_date.click();
				break;
			}
		}
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}

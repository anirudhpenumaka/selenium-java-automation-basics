package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement dropCountry=driver.findElement(By.xpath("//select[@id='country']"));
		Select dropCountryEle=new Select(dropCountry);
		
		//Select By Visible Text
		dropCountryEle.selectByVisibleText("India");
		Thread.sleep(3000);
		//Select by Value
		dropCountryEle.selectByIndex(4);
		Thread.sleep(3000);
		//Select by value
		dropCountryEle.selectByValue("japan");
		
		//No of drop options available
		List<WebElement> options=dropCountryEle.getOptions();
		System.out.println(options.size());
		
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
			System.out.println(options.get(i));
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}

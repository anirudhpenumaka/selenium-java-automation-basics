package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE_Practise {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		//Name
		WebElement inputname=driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		js.executeScript("arguments[0].setAttribute('value','John')", inputname);
		
		
		//Click action
		WebElement radiobtn=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radiobtn);
		
		//Scrollbar
		//approach01
	//	js.executeScript("window.scrollBy(0,1500)", "");
		//System.out.println(js.executeScript("return.window pageYoffset"));
		
		//Approach02 - searching an element by scrolling down
		//WebElement ele=driver.findElement(By.xpath("//h2[normalize-space()='Dynamic Web Table']"));
		//js.executeScript("arguments[0].ScrollIntoView()", ele);
		
		//navigate to the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		
		js.executeScript("document.body.style.zoom='50%'");
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}

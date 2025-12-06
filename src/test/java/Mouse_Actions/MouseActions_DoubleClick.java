package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions_DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/?utm_source=chatgpt.com");
		driver.manage().window().maximize();
		
		WebElement field01=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field02=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement DC=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		field01.clear();
		field01.sendKeys("Virat and Anushka");
		Actions act=new Actions(driver);
		
		act.doubleClick(DC).perform();
		
		System.out.println(field02.getText());
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}

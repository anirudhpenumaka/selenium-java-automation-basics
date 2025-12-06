package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions_MouseHover {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		
		WebElement Desktop=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement Mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions act=new Actions(driver);
		//Mouse Hover
		act.moveToElement(Desktop).moveToElement(Mac).click().build().perform();
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}

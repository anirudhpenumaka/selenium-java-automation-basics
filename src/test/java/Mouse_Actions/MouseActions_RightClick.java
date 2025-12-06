package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions_RightClick {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions act=new Actions(driver);
		//Right click
		act.contextClick(button).build().perform();
		
		//click on copy
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy context-menu-hover context-menu-visible']")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}

}

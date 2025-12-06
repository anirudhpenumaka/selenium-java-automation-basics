package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions_DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/?utm_source=chatgpt.com");
		driver.manage().window().maximize();
		
		
		
		WebElement push=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement trash=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(push, trash).perform();
		
		
		Thread.sleep(3000);
		driver.quit();
		// 

	}

}

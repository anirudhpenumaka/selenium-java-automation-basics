package CheckBoxes_AlertsandPoPups;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Specific_Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input'][ @type='checkbox']"));
		
		for(WebElement x:checkboxes)
		{
			x.click();
		}
		
		//uncheck them
		for(int i=3;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}

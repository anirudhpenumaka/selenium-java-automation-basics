package WebTables;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dynamic_WebTable {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-password-manager-reauthentication");
		options.addArguments("--disable-save-password-bubble");

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.opencart.com/TlbeVW/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse5']//a[contains(text(),'Customers')]")).click();
		
		String s="Showing 1 to 10 of 28622 (2863 Pages)";
		
		//s.substring(26,30);
		String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int totalpages=Integer.parseInt(text.substring(s.indexOf("(")+1, s.indexOf("Pages")-1));
		
		//repeating pages
		for(int p=1;p<=totalpages;p++)
		{
			if(p>1)
			{
				WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='+p+']"));
				active_page.click();
			}
			
			//reading data from the page
			int rows=driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tr")).size();
			System.out.println(rows);
			
			int cols=driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//td")).size();
			System.out.println(cols);
			
			//table[@class="table table-bordered table-hover"]//tr[2]//td[2]
			
			for(int r=2;r<=rows;r++)
			{
				for(int c=1;c<=cols;c++)
				{
					String value=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tr["+r+"]//td["+c+"]")).getText();
					System.out.println(value);
				}
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}

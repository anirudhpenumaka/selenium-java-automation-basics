package WebDriver_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate_Commands {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://amazon.in/");
		driver.manage().window().maximize();
		
		
		//Navigate commands
		driver.navigate().to("https://www.google.co.in/index.html");//amazon to google
		Thread.sleep(1000);
		driver.navigate().back(); //google to amazon
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}

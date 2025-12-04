package WebDriver_Methods;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//get(URL)
		driver.get("https://amazon.in/");
		
		//getTitle()
		String title=driver.getTitle();
		System.out.println(title);
		
		//current URL
		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);
		
		//pageSource
		String pageSource=driver.getPageSource();
		System.out.println(pageSource);
		
		//getWindowHandle
		String windowhandle=driver.getWindowHandle();
		System.out.println(windowhandle);
		
		//getWindowHandles
		Set<String> windowHandles=driver.getWindowHandles();
		for(String x:windowHandles)
		{
			System.out.println(x);
		}
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}

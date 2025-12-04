package Absolute_Relative_xpaths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Absolute_XPath 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in/");
		
		//for Search option, Select the element you want the Path of right click-->Copy--> Copy Full XPath
		//--> Absolute Xpath--> /html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input
		
		Thread.sleep(3000);
		driver.quit();

	}

}

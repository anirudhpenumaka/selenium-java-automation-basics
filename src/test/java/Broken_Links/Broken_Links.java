package Broken_Links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.mk_latn.No;

public class Broken_Links {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		int count=0;
		
		//Links should have href
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int number_of_brokenLinks=0;
		
		//find href links
		for(WebElement linkElement:links)
		{
			String href=linkElement.getAttribute("href");
			
			if(href==null || href.isEmpty())
			{
				System.out.println("check not possible");
				continue;
			}
			
			try
			{
				URL linkurl=new URL(href);
				HttpURLConnection connURL=(HttpURLConnection) linkurl.openConnection();
				
				connURL.connect();
				
				
				if(connURL.getResponseCode()>=400)
					{
						//System.out.println("Broken links");
						number_of_brokenLinks++;
					}
				else
					{
						System.out.println("Not Broken links");
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
		}
		System.out.println("No. of broken links="+ number_of_brokenLinks);
		
		Thread.sleep(3000);
		driver.quit();
	}

}

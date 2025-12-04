package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators 
{
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in/");
		
		//1 tag id --> tag#id
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Pens");
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).clear();
		Thread.sleep(3000);
		
		//2. tag class --> tag.class
		driver.findElement(By.cssSelector("input.nav-input")).sendKeys("Pokemons");
		driver.findElement(By.cssSelector("input.nav-input")).clear();
		Thread.sleep(3000);
		
		//3. tag attribute  --> tag[attribute='value']
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Anime");
		driver.findElement(By.cssSelector("input[type='text']")).clear();
		Thread.sleep(3000);
		
		//4. tag class attribute --> tag.classname[attribute='value']
		driver.findElement(By.cssSelector("input.nav-input[type='text']")).sendKeys("Beyblade");
		driver.findElement(By.cssSelector("input.nav-input[type='text']")).clear();
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
}

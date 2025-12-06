package Shadow_DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multi_Nested_Shadow_DOM {

	public static void main(String[] args)  throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://dev.automationtesting.in/shadow-dom");
			
			//we directly get cssSelectors for each DOM
			//This Element is inside 3 nested shadow DOM.
			//This Element is inside 3 nested shadow DOM.
			String cssSelectorForHost1 = "#shadow-root";
			String cssSelectorForHost2 = "#inner-shadow-dom";
			String cssSelectorForHost3 = "#nested-shadow-dom";
			Thread.sleep(1000);
			SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
			Thread.sleep(1000);
			SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
			Thread.sleep(1000);
			SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
			Thread.sleep(1000);
			WebElement nested02=shadow2.findElement(By.cssSelector("#multi-nested-shadow-element"));
			System.out.println(nested02.getText());
			
			Thread.sleep(3000);
			driver.quit();

		

	}

}

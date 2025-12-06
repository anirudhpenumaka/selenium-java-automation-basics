package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BootstrapDropDowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("C:/Java Workspace/Random for now/bootstrap-dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Select single options
		//driver.findElement(By.id("dropdownMenuButton")).click();
		//driver.findElement(By.xpath("//a[text()='Java']")).click();
		
		
		//Multi Select Options
		/*
		driver.findElement(By.id("dropdownSkills")).click();
		driver.findElement(By.xpath("//a[text()='API Testing']")).click();
		driver.findElement(By.id("dropdownSkills")).click();
		driver.findElement(By.xpath("//a[text()='Manual Testing']")).click();
		*/
		
		
		//Bootstrap Dropdown with Checkboxes
		/*driver.findElement(By.xpath("//button[@id='dropdownTools']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @id='tool1']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @id='tool2']")).click();
		*/
		
		//4. Searchable Bootstrap Dropdown
		
		driver.findElement(By.id("dropdownCountry")).click();
		driver.findElement(By.id("searchInput")).sendKeys("Ind");
		driver.findElement(By.xpath("//a[text()='India']")).click();
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}

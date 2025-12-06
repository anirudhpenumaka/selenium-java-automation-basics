package File_Uploads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Single_File_Upload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		
		//single file upload
		//driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C://Java Workspace/upload_file_1.txt");
		
		//multiple file upload
		String file01="C://Java Workspace/upload_file_1.txt";
		String file02="C://Java Workspace/upload_file_2.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file01+"\n"+file02);
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}

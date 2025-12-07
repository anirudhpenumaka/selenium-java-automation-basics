package DataDrivenTesting;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        String filePath = System.getProperty("user.dir") + "\\testdata\\caldata.xlsx";

        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

        for (int i = 1; i <= rows; i++) {

            // 1️⃣ READ DATA FROM EXCEL
            String princ = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String rate = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
            String exp_mvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

            // 2️⃣ ENTER DATA INTO APPLICATION
            driver.findElement(By.id("principal")).sendKeys(princ);
            driver.findElement(By.id("interest")).sendKeys(rate);
            driver.findElement(By.id("tenure")).sendKeys(per1);

            Select periodDrop = new Select(driver.findElement(By.id("tenurePeriod")));
            periodDrop.selectByVisibleText(per2);

            Select freqDrop = new Select(driver.findElement(By.id("frequency")));
            freqDrop.selectByVisibleText(freq);

            driver.findElement(By.xpath("//div[@class='cal_div']/a[1]")).click(); // Calculate

            // 3️⃣ VALIDATION
            String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

            if (Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {

                System.out.println("Test Passed");

                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);

            } else {

                System.out.println("Test Failed");

                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
            }

            // 4️⃣ CLEAR FOR NEXT LOOP
            Thread.sleep(1500);
            driver.findElement(By.xpath("//img[@class='PL5']")).click();
        }

        driver.quit();
    }
}

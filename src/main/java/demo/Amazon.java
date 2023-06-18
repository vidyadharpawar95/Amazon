package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
    ChromeDriver driver;
    public Amazon()
    {
        System.out.println("Constructor: Amazon");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        WebElement search= driver.findElement(By.id("APjFqb"));
        search.sendKeys("Amazon");
        search.submit();

        String text= driver.findElement(By.xpath("(//span[text()='Amazon.in'])[1]")).getText();
        System.out.println("Text of the link="+text);
        
        System.out.println("end Test case: testCase01");
    }

}

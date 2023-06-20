package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedin {
    ChromeDriver driver;
    public Linkedin()
    {
        System.out.println("Constructor: TestCases");
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

    
    public void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.linkedin.com/checkpoint/lg/sign-in-another-account");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("unknow");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("unknow");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'][1]/strong)[1]"));
		driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[1]//strong"));
		driver.findElement(By.xpath("//*[text()='Start a post']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]//p")).sendKeys("Hi Connection");
        System.out.println("end Test case: testCase02");
    }
 
}

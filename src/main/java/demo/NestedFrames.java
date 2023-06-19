package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {
    ChromeDriver driver;
    public NestedFrames()
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
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        // this one is top frame so we have switch from top
		WebElement frame1St= driver.findElement(By.xpath("//*[@name='frame-top']"));
		driver.switchTo().frame(frame1St); 
		
		//After top we switched on left frame and get the text of that frame
		driver.switchTo().frame("frame-left");
		String frameLeft=driver.findElement(By.xpath("//*[contains(text(),'LEFT')]")).getText();
		System.out.println("Text of the left frame="+frameLeft);
		
		//now we have switched back to parent frame i.e top frame
		driver.switchTo().parentFrame();
		
		//now we can switched on middle frame
		driver.switchTo().frame("frame-middle");
		String frameMiddle= driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]")).getText();
        System.out.println("Text of the Middle frame="+frameMiddle);
        
        //again we have to switched back to top frame
        driver.switchTo().parentFrame();
        
        //now we can switch on middle frame
        driver.switchTo().frame("frame-right");
        String frameRight= driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]")).getText();
        System.out.println("Text of the Right frame="+frameRight);
        
        // we have to switched back to default frame
        driver.switchTo().defaultContent();
        
       //now we can switch on middle frame
        driver.switchTo().frame("frame-bottom");
        String frameBottom= driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]")).getText();
        System.out.println("Text of the Right frame="+frameBottom);
        System.out.println("end Test case: testCase01");
    }

}

package demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w3WinHandle {
    ChromeDriver driver;
    public w3WinHandle()
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

    
    public  void testCase01() throws IOException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
          driver.switchTo().frame("iframeResult");
		
	    WebElement tryIt=  driver.findElement(By.xpath("//button[text()='Try it' or @class='myFunction()']"));
	    tryIt.click();
		Set<String> handle= driver.getWindowHandles();
		Iterator<String> itr= handle.iterator();
	    String parentWindowID=itr.next();
	    String childWindowID=itr.next();
	    System.out.println(parentWindowID);
	    System.out.println(childWindowID);
	    String title= driver.switchTo().window(childWindowID).getTitle();
	    System.out.println("title of the child window="+title);
	    
	    String childPageURL=driver.getCurrentUrl();
	    System.out.println("Url of child page="+childPageURL);
	    
	    File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File("C:\\Users\\vidya\\Desktop\\selenium ss\\w3schoolVSCODE.png"));
        System.out.println("end Test case: testCase01");
    }
}

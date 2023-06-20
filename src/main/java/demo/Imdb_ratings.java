package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imdb_ratings {
    ChromeDriver driver;
    public Imdb_ratings()
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
       driver.get("https://www.imdb.com/chart/top");
		WebElement dropDown= driver.findElement(By.xpath("//*[@name='sort']"));
		dropDown.click();
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("IMDb Rating");
		String text= driver.findElement(By.xpath("//a[text()='The Shawshank Redemption']")).getText();
		System.out.println("Highest rated movie on Imdb="+text);
		
		String count= driver.findElement(By.xpath("(//span[text()='250'])[1]")).getText();
		System.out.println("movies are included in the table="+count);
		
		sel.selectByValue("us:descending");
		
		String oldMovie= driver.findElement(By.xpath("//a[text()='The Kid']")).getText();
		System.out.println("oldest movie on the list is="+oldMovie);
		
		String newMovie= driver.findElement(By.xpath("//a[text()='Spider-Man: Across the Spider-Verse']")).getText();
		System.out.println("most recent movie on the list is="+newMovie);
		
		sel.selectByValue("nv:descending");
		
		String userRating= driver.findElement(By.xpath("//a[text()='The Shawshank Redemption']")).getText();
		System.out.println("The movie has the most user ratings is="+userRating);
        System.out.println("end Test case: testCase02");
    }

}

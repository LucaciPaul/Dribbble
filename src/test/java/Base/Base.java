package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;


    @Before
    public  void Setup2() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Automation\\Edge\\msedgedriver.exe");
        driver = new EdgeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://dribbble.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void Teardown(){
        driver.quit();
    }







}

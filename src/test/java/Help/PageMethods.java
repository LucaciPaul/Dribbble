package Help;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver=driver;
    }

    //Validate Title
    public void ValidateTitleOfPage(String Expected){
        WaitAfterPage(Expected);
        String Actual=driver.getTitle();
        Assert.assertEquals("The title of the page is not as expected",Expected, Actual);
    }

    //Wait after page
    public void WaitAfterPage(String value){
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs(value));
    }



}

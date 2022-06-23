package Test;

import Base.Base;
import Help.ElementMethods;
import Help.PageMethods;
import Property.PropertyUtility;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;

public class Dribbble extends Base {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public PageMethods pageMethods;
    public ElementMethods elementMethods;
    public PropertyUtility propertyUtility;

    @Test

    public void Dribbble() throws InterruptedException, IOException {

        pageMethods = new PageMethods(driver);
        elementMethods = new ElementMethods(driver);
        propertyUtility = new PropertyUtility("Resources");

        //Page validation
        String ExpectedDribbbleTitle = "Dribbble - Discover the World’s Top Designers & Creative Professionals";
        pageMethods.ValidateTitleOfPage(ExpectedDribbbleTitle);

        //Log-in
        WebElement signin=driver.findElement(By.xpath("//a[@data-site-nav-element='Sign in']"));
        elementMethods.ClickElement(signin);

        WebElement login=driver.findElement(By.id("login"));
        elementMethods.ClickElement(login);
        String Username= propertyUtility.getvalue("Username");
        elementMethods.SendKeyElement(login, Username);

        WebElement passw=driver.findElement(By.id("password"));
        elementMethods.ClickElement(passw);
        String Password= propertyUtility.getvalue("Password");
        elementMethods.SendKeyElement(passw, Password);

        WebElement submitsignin= driver.findElement(By.xpath("//input[@tabindex='3']"));
        elementMethods.ClickElement(submitsignin);


        //Filters
        WebElement filters= driver.findElement(By.xpath("//span[@title='Filters']"));
        elementMethods.ClickElement(filters);

        //3.Filter by “Timeframe” and select This Past Week option and check that dropdown has the option selected
        // Timeframe filter doesn't exist anymore

        WebElement tags= driver.findElement(By.id("tag"));
        elementMethods.ClickElement(tags);
        String tag1= propertyUtility.getvalue("tag1");
        elementMethods.SendKeyElement(tags, tag1);
        tags.sendKeys(Keys.RETURN);
        WebElement bodyclick=driver.findElement(By.id("wrap-inner"));
        elementMethods.ClickElement(bodyclick);


        //Check first 4 elements - I know this isn't the approach that you're looking for...
        //List<WebElement> cards=driver.findElements(By.className("js-thumbnail-grid shots-grid group dribbbles container-fluid is-scrolled"));
        boolean element1 = driver.findElement(By.id("screenshot-18559108")).isDisplayed();
        System.out.println("Element 1 is displayed: " +element1);
        boolean element2 = driver.findElement(By.id("screenshot-18557380")).isDisplayed();
        System.out.println("Element 2 is displayed: " +element2);
        boolean element3 = driver.findElement(By.id("screenshot-18501070")).isDisplayed();
        System.out.println("Element 3 is displayed: " +element3);
        boolean element4 = driver.findElement(By.id("screenshot-18553677")).isDisplayed();
        System.out.println("Element 4 is displayed: " +element4);

        //Check Save Shot and Like buttons
        WebElement card= driver.findElement(By.id("screenshot-18559108"));
        elementMethods.HoverElement(card);

        boolean saveshot = driver.findElement(By.xpath("//a[@title='Save shot']")).isDisplayed();
        System.out.println("Save Shot button is displayed: " +saveshot);

        boolean like = driver.findElement(By.id("shots-like-button")).isDisplayed();
        System.out.println("Like button is displayed: " +like);

        //Check Likes and Views
        String Likes = driver.findElement(By.xpath("//*[@id=\"screenshot-18559108\"]/div[2]/div[2]/div[1]/span")).getText();
        System.out.println("Nr. of likes: " +Likes);

        String Views = driver.findElement(By.xpath("//*[@id=\"screenshot-18559108\"]/div[2]/div[2]/div[2]/span")).getText();
        System.out.println("Nr. of views: " +Views);



    }


}
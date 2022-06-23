package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    //Wait for Element
    public void WaitAfterVisibleElement(WebElement Element){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Element));
    }

    //Click
    public void ClickElement(WebElement Element) {
        WaitAfterVisibleElement(Element);
        Element.click();
    }

    //SendKeys
    public void SendKeyElement(WebElement Element, String value){
        WaitAfterVisibleElement(Element);
        Element.sendKeys(value);
    }

    //Hover
    public void HoverElement(WebElement Element){
        Actions actions = new Actions(driver);
        actions.moveToElement(Element).build().perform();
    }

}

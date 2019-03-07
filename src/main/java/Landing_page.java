import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class Landing_page {
    private Wait<WebDriver> wait = new FluentWait<>(Driver.get_driver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(NoSuchElementException.class)
            .ignoring(NullPointerException.class);
    @FindBy(xpath="//a[@title='My Store']")
    private WebElement logo;
    @FindBy(xpath="//a[text()[contains(.,'Sign in')]]")
    private WebElement sign_in;
    @FindBy (xpath = "//a[@title='T-shirts']")
    private WebElement Tshirts;

    void verify_landing_page(){
        Assert.assertTrue(logo.isDisplayed(),"Fail to load landing page");
    }
    void click_sign_in(){
        sign_in.click();
    }
    void Tshirts_click(){ ((JavascriptExecutor)(Driver.get_driver())).executeScript("arguments[0].click();", Tshirts); }
}

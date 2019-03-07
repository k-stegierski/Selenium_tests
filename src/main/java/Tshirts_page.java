import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Tshirts_page {
    private Wait<WebDriver> wait = new FluentWait<>(Driver.get_driver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(NoSuchElementException.class)
            .ignoring(NullPointerException.class);
    @FindBy(xpath="//span[@itemprop='price']")
    private WebElement tshirt_price;
    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement add_to_cart;
    @FindBy(xpath="//i[@class='icon-th-list']")
    private WebElement switch_to_list;
    @FindBy (xpath="//span[text()[contains(.,'Proceed to checkout')]]")
    private WebElement confirm_buy;

    String get_tshirt_price(){
//        wait.until(webDriver -> !tshirt_price.getText().isEmpty());
        return tshirt_price.getText().trim();
    }
    void add_tshirt_to_cart(){
        switch_to_list.click();
        wait.until(ExpectedConditions.elementToBeClickable(add_to_cart));
        add_to_cart.click();
    }
    void proceed_to_checkout(){
        wait.until(ExpectedConditions.visibilityOf(confirm_buy));
        ((JavascriptExecutor)Driver.get_driver()).executeScript("arguments[0].click();",confirm_buy);
    }
}

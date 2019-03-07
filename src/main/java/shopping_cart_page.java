import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class shopping_cart_page {
    private Wait<WebDriver> wait = new FluentWait<>(Driver.get_driver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(NoSuchElementException.class)
            .ignoring(NullPointerException.class);
    @FindBy(id="cart_title")
    private WebElement shopping_cart_title;
    @FindBy (id="total_product")
    private WebElement total_price;

    void veriffy_page(){
        Assert.assertTrue(shopping_cart_title.isDisplayed());
    }
    String get_total_price(){
        wait.until(webDriver -> !total_price.getText().isEmpty());
        return total_price.getText().trim();
    }
}

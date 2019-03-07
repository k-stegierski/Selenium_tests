import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class My_account_page {
    @FindBy(xpath = "//*[text()='My account']")
    private WebElement account_header;

    void verify_account_page(){
        Assert.assertTrue(account_header.isDisplayed(),"Error on My account page");
    }

}

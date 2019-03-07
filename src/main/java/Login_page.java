import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page {
    @FindBy (id="email_create")
    private WebElement new_email;
    @FindBy (id="SubmitCreate")
    private WebElement create_acc;
    @FindBy (id="email")
    private WebElement existing_email;
    @FindBy (id="passwd")
    private WebElement password;
    @FindBy (id="SubmitLogin")
    private WebElement Login;


    void type_new_mail(String email){
        new_email.click();
        new_email.clear();
        new_email.sendKeys(email);
    }
    void create_acc_click(){
        create_acc.click();
    }
    void enter_credentials(String email){
        existing_email.click();
        existing_email.clear();
        existing_email.sendKeys(email);
        password.click();
        password.clear();
        password.sendKeys("123456");
    }
    void log_in(){
        Login.click();
    }
}

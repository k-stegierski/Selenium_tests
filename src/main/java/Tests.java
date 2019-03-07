import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tests implements Fake_data{
    private WebDriver driver;

    @BeforeMethod
    public void set_ff() {
        System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
        Driver.set_driver(new FirefoxDriver());
        driver = Driver.get_driver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }
    @Test
    public void TC1_Register_new_user() {
        Landing_page Landing = PageFactory.initElements(driver,Landing_page.class);
        Landing.verify_landing_page();
        Landing.click_sign_in();
        Login_page Login = PageFactory.initElements(driver,Login_page.class);
        Login.type_new_mail(email);
        Login.create_acc_click();
        new_acc_form new_account = PageFactory.initElements(driver,new_acc_form.class);
        new_account.verify_section_visible();
        new_account.verify_email(email);
        if(new Random().nextBoolean()) new_account.select_male_customer();
        else new_account.select_female_customer();
        new_account.type_Customer_name(firstname);
        new_account.type_Customer_surname(surname);
        new_account.set_password("123456");
        new_account.set_birth_date(birthday);
        new_account.sign_up_for_newsletter();
        new_account.receive_special_offers();
        new_account.set_address_first_name(firstname);
        new_account.set_address_last_name(surname);
        new_account.set_address_company(company);
        new_account.set_address(address,address_2nd_line);
        new_account.set_city(city);
        new_account.select_state(state);
        new_account.set_zipcode(zipcode);
        new_account.provide_additional_info(additional_info);
        new_account.setHome_phone(homephone);
        new_account.set_mobile(mobile);
        new_account.assign_alias(alias);
        new_account.submit_form();
        My_account_page My_acc = PageFactory.initElements(driver,My_account_page.class);
        My_acc.verify_account_page();
    }
    @Test
    public void TC2_Authenticate_existing_user(){
        Landing_page Landing = PageFactory.initElements(driver,Landing_page.class);
        Landing.verify_landing_page();
        Landing.click_sign_in();
        Login_page Login = PageFactory.initElements(driver,Login_page.class);
        Login.enter_credentials(email);
        Login.log_in();
        My_account_page My_acc = PageFactory.initElements(driver,My_account_page.class);
        My_acc.verify_account_page();
    }
    @Test
    public void TC3_add_Tshirt_price_to_cart(){
        Landing_page Landing = PageFactory.initElements(driver,Landing_page.class);
        Landing.Tshirts_click();
        Tshirts_page tshirts = PageFactory.initElements(driver,Tshirts_page.class);
        tshirts.add_tshirt_to_cart();
        tshirts.proceed_to_checkout();
        shopping_cart_page cart = PageFactory.initElements(driver,shopping_cart_page.class);
        cart.veriffy_page();
    }
    @AfterMethod
    void teardown(){
        driver.quit();
    }
}
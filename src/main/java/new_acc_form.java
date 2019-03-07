import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;

public class new_acc_form {
    private Wait<WebDriver> wait = new FluentWait<>(Driver.get_driver())
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(NoSuchElementException.class)
            .ignoring(NullPointerException.class);
    @FindBy(xpath = "//*[text()='Your personal information']")
    private WebElement subheader;
    //Personal info
    @FindBy(id="id_gender1")
    private WebElement customer_gender_man;
    @FindBy(id="id_gender2")
    private WebElement customer_gender_female;
    @FindBy(id="customer_firstname")
    private WebElement customer_name;
    @FindBy (id="customer_lastname")
    private WebElement customer_surname;
    @FindBy (id="email")
    private WebElement email;
    @FindBy (id="passwd")
    private WebElement password;
    @FindBy(id="days")
    private WebElement day_of_birth;
    @FindBy (id="months")
    private WebElement month_of_birth;
    @FindBy (id="years")
    private WebElement year_of_birth;
    @FindBy (id="newsletter")
    private WebElement newsletter;
    @FindBy (id="optin")
    private WebElement special_offers;
    //Address
    @FindBy(id="firstname")
    private WebElement address_first_name;
    @FindBy(id="lastname")
    private WebElement address_last_name;
    @FindBy(id="company")
    private WebElement company;
    @FindBy (id="address1")
    private WebElement address;
    @FindBy (id="address2")
    private WebElement address_2nd_line;
    @FindBy (id="city")
    private WebElement city;
    @FindBy(id="id_state")
    private WebElement state;
    @FindBy(id="postcode")
    private WebElement postcode;
    @FindBy(id="other")
    private WebElement add_info;
    @FindBy(id="phone")
    private WebElement home_phone;
    @FindBy(id="phone_mobile")
    private WebElement mobile;
    @FindBy(id="alias")
    private WebElement alias;
    @FindBy(id="submitAccount")
    private WebElement submitAccount;

    void verify_section_visible(){
        wait.until(ExpectedConditions.visibilityOf(subheader));
    }
    void verify_email(String email){
        wait.until(webDriver -> !this.email.getAttribute("value").isEmpty());
        Assert.assertEquals(email,this.email.getAttribute("value"),"Email address not transferred");
    }
    void select_male_customer(){
        customer_gender_man.click();
    }
    void select_female_customer(){
        customer_gender_female.click();
    }
    void type_Customer_name(String name){
        customer_name.click();
        customer_name.clear();
        customer_name.sendKeys(name);
    }
    void type_Customer_surname(String surname){
        customer_surname.click();
        customer_surname.clear();
        customer_surname.sendKeys(surname);
    }
    void set_password(String password){
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
    }
    void set_birth_date(String date_of_birth){
        date_of_birth = date_of_birth.replace("/","-"); //in case of wrong input
        String[] date_of_birth_t = date_of_birth.split("-");
        if(Integer.valueOf(date_of_birth_t[0])<10) date_of_birth_t[0]=date_of_birth_t[0].replace("0","");
        if(Integer.valueOf(date_of_birth_t[1])<10) date_of_birth_t[1]=date_of_birth_t[1].replace("0","");
        new Select(day_of_birth).selectByValue(date_of_birth_t[0]);
        new Select(month_of_birth).selectByValue(date_of_birth_t[1]);
        new Select(year_of_birth).selectByValue(date_of_birth_t[2]);
    }
    void sign_up_for_newsletter(){
        newsletter.click();
    }
    void receive_special_offers(){
        special_offers.click();
    }
    void set_address_first_name(String name){
        address_first_name.click();
        address_first_name.clear();
        address_first_name.sendKeys(name);
    }
    void set_address_last_name(String name){
        address_last_name.click();
        address_last_name.clear();
        address_last_name.sendKeys(name);
    }
    void set_address_company(String company_name){
        company.click();
        company.clear();
        company.sendKeys(company_name);
    }
    void set_address(String firstline, String secondline){
        address.click();
        address.clear();
        address.sendKeys(firstline);
        address_2nd_line.click();
        address_2nd_line.clear();
        address_2nd_line.sendKeys(secondline);
    }
    void set_city(String city){
        this.city.click();
        this.city.clear();
        this.city.sendKeys(city);
    }
    void select_state(String state_name){
        new Select(state).selectByVisibleText(state_name);
    }
    void set_zipcode(String zipcode){
        postcode.click();
        postcode.clear();
        postcode.sendKeys(zipcode);
    }
    void provide_additional_info(String info){
        add_info.click();
        add_info.clear();
        add_info.sendKeys(info);
    }
    void setHome_phone(String phone_num){
        home_phone.click();
        home_phone.clear();
        home_phone.sendKeys(phone_num);
    }
    void set_mobile(String phone_num){
        mobile.click();
        mobile.clear();
        mobile.sendKeys(phone_num);
    }
    void assign_alias(String alias){
        this.alias.click();
        this.alias.clear();
        this.alias.sendKeys(alias);
    }
    void submit_form(){
        submitAccount.click();
    }



}
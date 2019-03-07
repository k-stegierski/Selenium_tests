import org.openqa.selenium.WebDriver;

public class Driver {
    private static ThreadLocal<WebDriver> selenium_instance = new ThreadLocal<WebDriver>();

    static WebDriver get_driver() {
        return selenium_instance.get();
    }
    static void set_driver(WebDriver driver) {
        selenium_instance.set(driver);
    }
}

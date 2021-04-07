import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

public class SampleTest {
    public FirefoxDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/mario/Downloads/geckodriver");
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void site_header_is_on_home_page() {
        driver.get("https://www.saucelabs.com");
        WebElement href = driver.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));
        assertTrue((href.isDisplayed()));
    }
}
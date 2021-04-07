import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class PurchaseTest {

    @Test
    void purchaseTest(FirefoxDriver driver) {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(550, 691));
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(2)")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'Rome']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Flights from Philadelphia to Rome:"));
        driver.findElement(By.cssSelector("th:nth-child(1)")).click();
        driver.findElement(By.cssSelector("th:nth-child(1)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("th:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        assertThat(driver.findElement(By.cssSelector("th:nth-child(1)")).getText(), is("Choose"));
        driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Chico Silva");
        driver.findElement(By.id("address")).sendKeys("Aqui ao lado");
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}

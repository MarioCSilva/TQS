package tqs.ex3;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemoSearchSteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void navigateTo(String url) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @And("I select my departure city {string}")
    public void selectDepartureCity(String dep){
        driver.findElement(By.name("fromPort")).click();
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = '" + dep + "']" )).click();
    }

    @And("I select my destination city {string}")
    public void selectDestinationCity(String dest){
        driver.findElement(By.name("toPort")).click();
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = '" + dest + "']")).click();
    }

    @And("I press {string}")
    public void pressButtonCity(String btn) {
        driver.findElement(By.xpath("//input[@value='" + btn + "']")).click();
    }

    @And("I enter my details")
    public void enterInformation(){
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Mário Silva");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Rua de Oliveira 11");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Oliveira");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("Aveiro");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("8885-123");
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("11212121");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("Mário Silva");
        driver.findElement(By.cssSelector(".checkbox")).click();
    }

    @Then("I see a list of {string}")
    public void seeListOfFlights(String airline){
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), containsString(airline));
    }

    @Then("The purchase should be confirmed and cost {int}")
    public void confirmPurchasePrice(int price){
        assertThat(driver.findElement(
                By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText(),
                is(price+ " USD"));
    }
}

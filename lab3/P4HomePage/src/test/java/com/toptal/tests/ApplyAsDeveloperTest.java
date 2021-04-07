package com.toptal.tests;

import com.toptal.webpages.DeveloperApplyPage;
import com.toptal.webpages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplyAsDeveloperTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        //use FF Driver
        System.setProperty("webdriver.gecko.driver", "/Users/mario/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterEach
    public void close(){
        driver.close();
    }

    @Test
    public void applyAsDeveloper() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        assertTrue(home.isPageOpened());
        home.clickOnDeveloperApplyButton();

        //Create object of DeveloperApplyPage
        DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);

        //Check if page is opened
        assertTrue(applyPage.isPageOpened());

        //Fill up data
        applyPage.setDeveloper_email("dejan@toptal.com");
        applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
        applyPage.setDeveloper_password("password123");
        applyPage.setDeveloper_password_confirmation("password123");

        //Accept Cookies to not obscure the join button
        applyPage.clickOnAcceptCookies();

        //Click on join
        applyPage.clickOnJoin();
    }


}
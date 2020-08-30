package com.github.gomboshkr.tests;

import java.util.concurrent.TimeUnit;

import com.github.gomboshkr.pages.GoogleSearchPage;
import com.github.gomboshkr.pages.ResultSearchPage;
import com.github.gomboshkr.utils.ApplicationProperties;
import com.github.gomboshkr.config.driver.Browsers;
import com.github.gomboshkr.config.driver.DriverFactory;
import org.assertj.core.api.WithAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author Kristian Gombosh
 */
public class BaseTest implements WithAssertions {
    public static WebDriver DRIVER;
    protected GoogleSearchPage googleSearchPage;
    protected ResultSearchPage resultSearchPage;

    @BeforeMethod
    public void setupTestRun() {
        final String browser = ApplicationProperties.BROWSER.toUpperCase();
        DRIVER = new DriverFactory().setBrowsers(Browsers.valueOf(browser)).create();
        DRIVER.manage().window().maximize();
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        initPages();
        DRIVER.get(ApplicationProperties.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        DRIVER.quit();
    }

    private void initPages() {
        googleSearchPage = new GoogleSearchPage(DRIVER);
        resultSearchPage = new ResultSearchPage(DRIVER);
    }
}

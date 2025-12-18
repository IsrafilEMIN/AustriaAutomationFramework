package at.company.steps;

import at.company.config.ConfigFactory;
import at.company.driver.DriverFactory;
import at.company.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(ConfigFactory.getConfig().loginUrl());
    }

    @After
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
        DriverManager.unload();
    }
}
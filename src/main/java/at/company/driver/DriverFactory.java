package at.company.driver;

import at.company.config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private DriverFactory() {}

    public static WebDriver getDriver() {

        String browser = ConfigFactory.getConfig().browser();

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else {
            throw new RuntimeException("Browser not recognized");
        }
    }
}

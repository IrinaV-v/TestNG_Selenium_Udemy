package testNGWeb;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    private static List<WebDriver> drivers = new ArrayList<>();

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\IdeaProjects\\drivers\\geckodriver.exe");

    }

    WebDriver getDriver() {
        return getDriver(BrowserType.CHROME, "https://google.com");
    }

    WebDriver getDriver(BrowserType type, String url) {
        WebDriver driver = DriverFactory.getInstance().getDriver(type);
        drivers.add(driver);
        driver.get(url);
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        for (WebDriver driver : drivers) {
            driver.quit();
        }

    }
}

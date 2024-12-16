package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverFactory {
    static WebDriver driver;
    @Step("open browser {browserName}")
    public static WebDriver initiateDriver(String browserName, boolean maximize) {
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if (isHeadless) {
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu", "--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage");
            }
            driver = new ChromeDriver(chromeOptions);
            System.out.println("Initializing Chrome Browser on OS: " + System.getProperty("os.name") + " and version: " + System.getProperty("os.version"));

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("intializing firefox Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("intializing Edge Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
            driver = new EdgeDriver();
        }
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("window is maximized , and the window size is " + driver.manage().window().getSize());
        }
        return driver;
    }
}

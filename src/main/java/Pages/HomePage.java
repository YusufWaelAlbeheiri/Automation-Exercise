package Pages;

import Utilities.DriverFactory;
import Utilities.JsonFileManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    public WebDriver driver;
    JsonFileManager jm;

    String username = "username";
    private By imageOfLogo = By.xpath("//img[@src='/static/images/home/logo.png']");
    private By signUpButton = By.linkText("Signup / Login");


    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    @Step("navigate to website")
    public HomePage navigate() {
        driver.navigate().to("https://automationexercise.com");
        return this;
    }

    @Step("Validate that the user is in home page")
    public HomePage asserThatUserISInHomePage() {
        Assert.assertTrue(driver.findElement(imageOfLogo).isDisplayed(), "User Is Not In Home Page");
//        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"),"Wrong URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "sdas");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        System.out.println("User in home page");
        return this;

    }


}

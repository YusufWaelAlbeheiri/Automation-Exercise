package Pages;

import Utilities.JsonFileManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavBar {
    private WebDriver driver;
    JsonFileManager jm;
    /// // Locators /////

    private By SignUporLoginButton = By.partialLinkText("Signup");
    private By deletebutton = By.xpath("//a[@href='/delete_account']");
    private By userNameIsVisibleInHomePage = By.xpath("//a[b]");


    public NavBar(WebDriver driver) {
        this.driver = driver;
    }


    /// /Action Methods/////
    /// //locate the sign-up link then perform action "clicking" on it
    @Step("Click on sign/login button")
    public NavBar clickOnSignUpLoginButton() {
        driver.findElement(SignUporLoginButton).click();
        System.out.println("Signup/Login Button has been clicked");
        return this;
    }

    @Step("Delete the account")
    public NavBar clickOnDeleteButton(){
        driver.findElement(deletebutton).click();
        return this;

    }
    @Step("Validate the appearnce of username in navbar")
    public NavBar asseertionOnAppearnceOfUserName(){
        jm = new JsonFileManager("src/test/resources/data.json");

        Assert.assertEquals(driver.findElement(userNameIsVisibleInHomePage).getText(), "Logged in as "+ jm.getTestData("UserName") ,"Username Is Not Visible");
        System.out.println("The usernam has been appeared on navbar");
        return this;
    }
}
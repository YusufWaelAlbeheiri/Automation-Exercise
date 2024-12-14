package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreated {
    public WebDriver driver;

    public void navigate() {
        driver.navigate().to("https://automationexercise.com/account_created");
    }


    private By continueButton = By.linkText("Continue");
    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");

    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on continue after accountcreation")
    public void clickOnContinueButtonInCreationPage() {
        driver.findElement(continueButton).click();

    }

    @Step("Assert on appearnce of account created message")
    public AccountCreated assertThatCreateMessageIsAppear() {
        Assert.assertEquals(driver.findElement(accountCreatedMessage).getText(), "ACCOUNT CREATED!", "Message Is Not Displayed");
        System.out.println("The account has been created successfully");
        return this;
    }
}

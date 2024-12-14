package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeletionPage {
    public WebDriver driver;

    public DeletionPage(WebDriver driver) {
        this.driver = driver;
    }

    private By deleteMessageIsVisible = By.xpath("//h2[@data-qa='account-deleted']");
    private By continueButtonInDeletePage = (By.linkText("Continue"));

    @Step("Click on contniue button in delete page")
    public void clickOnContinueButtonInDeletionPage() {
        driver.findElement(continueButtonInDeletePage).click();

    }

    @Step("Validate that the account has been deleted and the message has been appeared")
    public DeletionPage asserThatDeleteMessageIsDisplayed() {
        Assert.assertEquals(driver.findElement(deleteMessageIsVisible).getText(), "ACCOUNT DELETED!", "Message Is Not Displayed");
        System.out.println("The deletion message has been appeared");
        return this;
    }
}

package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage {

    public WebDriver driver;
    private By signUpText = By.xpath("//div[@class='signup-form']/h2");
    private By nameField = By.name("name");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    public void SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to("https://automationexercise.com/login");
    }

    @Step("Validate that the user is in sign up login page")
    public SignUpPage assertThatUserIsInSignupLoginPage() {
        Assert.assertEquals(driver.findElement(signUpText).getText(), "New User Signup!", "Message That New User Signup Is Not Visible");
//        Assert.assertTrue(driver.findElement(signUpText).isDisplayed(),"Error");
        System.out.println("The user in sign/login page");

        return this;
    }

    @Step("Fill the sign up form and click on sign up button")
    public void fillSignupForm(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(signUpButton).click();
    }
}


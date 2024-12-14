package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationForm {
    public WebDriver driver;

    private By enterInfoText = By.xpath("//b[contains(text(),'Enter Account Information')]");
    private By passwordField = By.name("password");
    private By radioButtonMale = By.id("id_gender1");
    private By radioButtonFemale = By.id("id_gender2");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By optinCheckbox = By.id("optin");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private By firstName = By.id("first_name");
    private By secondName = By.name("last_name");
    private By companyName = By.id("company");
    private By firstAddress = By.id("address1");
    private By secondAddress = By.id("address2");
    private By selectCountry = By.id("country");
    private By selectState = By.id("state");
    private By selectCity = By.id("city");
    private By selectZipCode = By.id("zipcode");
    private By selectMobileNumber = By.id("mobile_number");
//    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");


    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to("https://automationexercise.com/signup");
    }

    @Step("Validate the appearnce on info text")
    public RegistrationForm asseertionOnEnterInfoTex() {
        Assert.assertEquals(driver.findElement(enterInfoText).getText(), "ENTER ACCOUNT INFORMATION");
        System.out.println("The account info text has been appeared");
        return this;
    }

    @Step("Enter account info")
    public RegistrationForm enterAccountInformation(String firstname, String secondname, String pass, String gender, String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(secondName).sendKeys(secondname);
        driver.findElement(passwordField).sendKeys(pass);
//        driver.findElement(selectGender).click();
        if (gender.equals("male")) {
            driver.findElement(radioButtonMale).click();
        } else if (gender.equals("female")) {
            driver.findElement(radioButtonFemale).click();
        } else {
            System.out.println("Invalid Choice");
        }
        new Select(driver.findElement(dayDropdown)).selectByVisibleText(dayOfBirth);
        new Select(driver.findElement(monthDropdown)).selectByVisibleText(monthOfBirth);
        new Select(driver.findElement(yearDropdown)).selectByVisibleText(yearOfBirth);
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(optinCheckbox).click();
        return this;
    }

    @Step("Enter address info")
    public RegistrationForm enterAddressInformation(String companyname, String firstAd, String secondAd, String country, String city, String state, String codezip, String mobilePhone) {

        driver.findElement(companyName).sendKeys(companyname);
        driver.findElement(firstAddress).sendKeys(firstAd);
        driver.findElement(secondAddress).sendKeys(secondAd);
        new Select(driver.findElement((selectCountry))).selectByVisibleText(country);
        driver.findElement(selectCity).sendKeys(city);
        driver.findElement(selectState).sendKeys(state);
        driver.findElement(selectZipCode).sendKeys(codezip);
        driver.findElement(selectMobileNumber).sendKeys(mobilePhone);
        return this;
    }

    @Step("Click on create account button")
    public void clickOnCreatAccountButton() {
        driver.findElement(createAccountButton).click();
        System.out.println("The user has been clicked on Create account button");

    }

}



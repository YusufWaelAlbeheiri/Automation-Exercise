package tests;

import Pages.*;
import Utilities.DriverFactory;
import Utilities.JsonFileManager;
import Utilities.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPOM {
    WebDriver driver;
    JsonFileManager json;
//    DriverFactory driverFactor;
//    String username="salah";
//    String mail="cristiano@saalah.com";
//    DeletionPage deletionPage;
//    AccountCreated accountCreated ;
//    HomePage homePage ;
//    SignUpPage signUpPage;


    @Test
    @Description("Registration Test")
    public void regstrationTest() {
        new HomePage(driver)
                .navigate()
                .asserThatUserISInHomePage();
        new NavBar(driver)
                .clickOnSignUpLoginButton();
        new SignUpPage(driver)
                .assertThatUserIsInSignupLoginPage()
                .fillSignupForm(json.getTestData("UserName"), json.getTestData("UserMail"));

        new RegistrationForm(driver)
                .asseertionOnEnterInfoTex()
                .enterAccountInformation("wael", "karim", "Password", "male", "24", "July", "2002")
                .enterAddressInformation("giza systems", "hadyaek el kobbah", "hadyaek el kobbah", "India", "cairo", "cairo", "134", "01231331234")
                .clickOnCreatAccountButton();

        new AccountCreated(driver)
                .assertThatCreateMessageIsAppear()
                .clickOnContinueButtonInCreationPage();
        new NavBar(driver)
                .asseertionOnAppearnceOfUserName()
                .clickOnDeleteButton();
        new DeletionPage(driver)
                .asserThatDeleteMessageIsDisplayed()
                .clickOnContinueButtonInDeletionPage();
    }

    @BeforeClass
    public void setUP() {

        json = new JsonFileManager("src/test/resources/data.json");
        driver = DriverFactory.initiateDriver(System.getProperty("browserName"),true,System.getProperty("headless"));


    }

    @AfterClass
    public void closing() {
        driver.quit();
    }

    @BeforeSuite
    public void beforeSuite() {
        PropertiesReader.loadProperties();

    }
}
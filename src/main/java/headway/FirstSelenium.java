package headway;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSelenium {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("http://automationexercise.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("name")).sendKeys("cristiano");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("messi@wael.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("id_gender1")).click();
//        WebElement dayDropDown = driver.findElement(By.id("days"));
       new Select(driver.findElement(By.id("days"))) .selectByValue("24");

        WebElement monthDropDown = driver.findElement(By.id("months"));
        Select selectmonth = new Select(monthDropDown);
        selectmonth.selectByIndex(1);
        WebElement yearsDropDown = driver.findElement(By.id("years"));
        Select selectyear = new Select(yearsDropDown);
        selectyear.selectByValue("2002");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("youssef");
        driver.findElement(By.id("last_name")).sendKeys("mohsen");
        driver.findElement(By.id("company")).sendKeys("giza systems");
        driver.findElement(By.id("address1")).sendKeys("1 Hadyaek el kobbah");
        driver.findElement(By.id("address2")).sendKeys("2 Hadyaek el kobbah");
        WebElement countryDropDown = driver.findElement(By.id("country"));
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByIndex(2);
        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("California");
        driver.findElement(By.id("zipcode")).sendKeys("1221413");
        driver.findElement(By.id("mobile_number")).sendKeys("1221413");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        String created = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        if (created.equals("ACCOUNT CREATED!"))
            System.out.println("CREATED");

        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        String deleted = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        if (deleted.equals("ACCOUNT DELETED!"))
            System.out.println("DELETED");
        driver.findElement(By.linkText("Continue")).click();
        driver.quit();
    }
}

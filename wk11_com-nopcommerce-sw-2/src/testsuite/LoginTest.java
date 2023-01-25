package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseURL = "https://demo.nopcommerce.com/"; //declare base URL

    @Before
    public void startUp() {
        openBrowser(baseURL); //open browser
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement loginInLink = driver.findElement(By.className("ico-login")); //find log in element on page
        loginInLink.click(); //click on link

        //verify welcome message
        WebElement welcomeMsg = driver.findElement(By.xpath("//h1[contains(text()," +
                "'Welcome, Please Sign In!')]"));
        String actualText = welcomeMsg.getText(); //get actual message
        String expectedText = "Welcome, Please Sign In!"; //declare expected message
        Assert.assertEquals(expectedText, actualText); //match text for test to pass
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on login link
        WebElement loginInLink = driver.findElement(By.className("ico-login")); //find log in element on page
        loginInLink.click(); //click on login link

        //enter email id in to email field
        WebElement emailIdField = driver.findElement(By.id("Email"));
        emailIdField.sendKeys("cbuster55@gmail.com"); //send keys to email field

        //enter password into password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("admin12345"); //send keys to password field

        //click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click(); //click on login button

        WebElement logOutLink = driver.findElement(By.className("ico-logout")); //find 'Log out' element
        String actualText = logOutLink.getText(); //get actual message
        String expectedText = "Log out"; //declare expected message
        Assert.assertEquals(expectedText, actualText); //match text for test to pass
    }

    @Test
    public void verifyTheErrorMessage () {
        //click on login link
        WebElement loginInLink = driver.findElement(By.className("ico-login")); //find log in element on page
        loginInLink.click(); //click on login link

        //enter email id in to email field
        WebElement emailIdField = driver.findElement(By.id("Email"));
        emailIdField.sendKeys("cbust555@gmail.com"); //send keys to email field

        //enter password into password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Admin12345"); //send keys to password field

        //click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click(); //click on login button

        //verify error message
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class=" +
                "'message-error validation-summary-errors']")); //find error message on page
        String actualText = errorMsg.getText(); //get actual message
        String expectedText = "Login was unsuccessful";
        String.valueOf(actualText.matches(expectedText)); //partial match text
    }

    @After
    public void shutDown() {
        closeBrowser(); //close browser
    }
}

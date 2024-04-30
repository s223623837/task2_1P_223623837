package sit707_week2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Set up WebDriver (ChromeDriver in this case)
        System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/chromedriver-mac-x64-2/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testValidUsernameAndPassword() throws InterruptedException {
        login("buntest@yopmail.com", "Raja123@");
        assertFalse(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testValidUsernameAndInvalidPassword() throws InterruptedException {
        login("buntest@yopmail.com", "invalidpassword");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testInvalidUsernameAndValidPassword() throws InterruptedException {
        login("invalidusername@wrong.com", "Raja123@");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testEmptyUsernameAndValidPassword() throws InterruptedException {
        login("", "Raja123@");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testValidUsernameAndEmptyPassword() throws InterruptedException {
        login("buntest@yopmail.com", "");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testInvalidUsernameAndEmptyPassword() throws InterruptedException {
        login("invalidusername", "");
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    private void login(String username, String password) throws InterruptedException {
        // Navigate to the login page
        driver.get("https://www.bunnings.com.au/login");

        // Find the username, password input fields, and sign-in button
        WebElement usernameField = driver.findElement(By.id("okta-signin-username"));
        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));

        // Enter credentials and click Sign In
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public static void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}

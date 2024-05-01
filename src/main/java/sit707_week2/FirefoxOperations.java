package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxOperations {

    // Method to introduce a delay in seconds
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to perform registration on Officeworks registration page
    public static void officeworks_registration_page(String url) {
        // Setting system property to specify the GeckoDriver path
        System.setProperty("webdriver.gecko.driver", "/Users/mac/Downloads/geckodriver");

        // Configuring FirefoxOptions to specify the location of the Firefox binary
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");

        // Initiating FirefoxDriver with specified options
        WebDriver driver = new FirefoxDriver(options);

        // Loading the specified URL in Firefox browser
        driver.get(url);

        // Interacting with the input fields on the registration form
        WebElement firstNameField = driver.findElement(By.id("firstname"));
        firstNameField.sendKeys("Ahsan");

        WebElement lastNameField = driver.findElement(By.id("lastname"));
        lastNameField.sendKeys("Habib");

        WebElement phoneNumberField = driver.findElement(By.id("phoneNumber"));
        phoneNumberField.sendKeys("0424876567");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("ahsan@example.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        confirmPasswordField.sendKeys("password123");

        // Clicking the 'Create account' button
        WebElement createAccountButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button"));
        createAccountButton.click();

        // Taking a screenshot of the webpage
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("firfoxScreenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adding a delay before closing the browser
        sleep(2);

        // Closing the Firefox browser
        driver.close();
    }

    // Method to perform registration on Indeed Flex registration page
    public static void indeed_flex__registration_page(String url) {
        // Setting system property to specify the GeckoDriver path
        System.setProperty("webdriver.gecko.driver", "/Users/mac/Downloads/geckodriver");

        // Configuring FirefoxOptions to specify the location of the Firefox binary
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");

        // Initiating FirefoxDriver with specified options
        WebDriver driver = new FirefoxDriver(options);

        // Loading the specified URL in Firefox browser
        driver.get(url);

        // Interacting with the input fields on the registration form
        WebElement emailField = driver.findElement(By.id("email-1"));
        emailField.sendKeys("ahsan@example.com");

        WebElement confirmEmailField = driver.findElement(By.id("emailConfirmation-2"));
        confirmEmailField.sendKeys("ahsan@example.com");

        WebElement passwordField = driver.findElement(By.id("password-3"));
        passwordField.sendKeys("password123");

        WebElement confirmPasswordField = driver.findElement(By.id("passwordConfirmation-4"));
        confirmPasswordField.sendKeys("password123");

        // Clicking the 'Agree' checkbox
        WebElement agreeField = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div/div[1]/div[2]/form/div/div[2]/label/span[1]/span[1]/input"));
        agreeField.click();

        // Clicking the 'Create account' button
        WebElement createAccountButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div/div[1]/div[3]/div/div/div"));
        createAccountButton.click();

        // Taking a screenshot of the webpage
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("firefoxscreenshot2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adding a delay before closing the browser
        sleep(2);

        // Closing the Firefox browser
        driver.close();
    }
}

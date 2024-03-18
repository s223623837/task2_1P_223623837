package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Bidhan Babu Gupta
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/chromedriver-mac-x64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Ahsan");
		
		/*
		 * Find following input fields and populate with values
		 */
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
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
	    WebElement createAccountButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/form/div[12]/button"));
	    createAccountButton.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(screenshot, new File("screenshot.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void indeed_flex__registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/chromedriver-mac-x64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
			
	    
	    WebElement emailField = driver.findElement(By.id("email-1"));
	    emailField.sendKeys("ahsan@example.com");

	    WebElement confirmEmailField = driver.findElement(By.id("emailConfirmation-2"));
	    confirmEmailField.sendKeys("ahsan@example.com");
	    
	    WebElement passwordField = driver.findElement(By.id("password-3"));
	    passwordField.sendKeys("password123");
	    
	    WebElement confirmPasswordField = driver.findElement(By.id("passwordConfirmation-4"));
	    confirmPasswordField.sendKeys("password123");
		
	    WebElement agreeField = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div/div[1]/div[2]/form/div/div[2]/label/span[1]/span[1]/input"));
	    agreeField.click();
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
	    WebElement createAccountButton = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div/div[1]/div[3]/div/div/div"));
	    createAccountButton.click();
	    
		sleep(2);

		/*
		 * Take screenshot using selenium API.
		 */
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(screenshot, new File("screenshot2.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
}

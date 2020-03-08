package cucumber_practice;

import cucumber.api.PendingException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Steps {
    private static final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver driver = new ChromeDriver();

    @Before
    public void openWindow() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        driver.get("https://www.linkedin.com/home");
    }

    @After
    public void closeWindow() {
        driver.quit();
    }


      @When("^I fill in Email with (string)$")
    public void iFillInEmailWithWithAtHttpsWwwLinkedinComHome() throws Throwable {
        WebElement emailField = driver.findElement(By.xpath("//div/input"));
        emailField.sendKeys(" ");
        throw new PendingException();
    }

    @And(value = "^I fill in Password with (string)$")
    public void iFillInPasswordWith() throws Throwable {
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='session_password']"));
        passwordField.sendKeys(" ");
        throw new PendingException();
    }

    @And("I click on the Log In button")
    public void iClickOnTheLogInButton() throws Throwable {
        WebElement loginButton = driver.findElement(By.xpath("//div[2]/button[contains(@class,'submit')]"));
        loginButton.click();
        throw new PendingException();
    }
    @Then("I should see Warning message")
    public void iShouldSeeMessage() {
        Assert.assertNotSame("https://www.linkedin.com/feed/", driver.getCurrentUrl());
        throw new PendingException();
    }


    @Then("^I am on the My profile page on URL$")
    public void iAmOnTheMyProfilePageOnURL() throws Throwable {
        Assert.assertEquals("https://www.linkedin.com/feed/", driver.getCurrentUrl());
        throw new PendingException();
    }


/*
    @When("^I fill in Email with (string)$")
    public void iFillInEmailWith(String arg0) {
        WebElement emailField = driver.findElement(By.xpath("//div/input"));
        emailField.sendKeys("4113888");
        throw new PendingException();
  */
    @When("I fill in Email with {1}")
    public void iFillInEmailWith(String arg0) {
    }
}
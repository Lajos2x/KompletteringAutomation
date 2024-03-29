package Stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Stepdefenition {

    public static void click(WebDriver driver, By by) {

        (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(by));

        driver.findElement(by).click();

    }

    private WebDriver driver;
    private WebElement result;

    @Given("i am on the email regrestration page in {string} https:\\/\\/login.mailchimp.com\\/signup\\/")
    public void i_am_on_the_email_regrestration_page_in_https_login_mailchimp_com_signup(String browser) {
        Webdrivers creator = new Webdrivers();
        driver = creator.createBrowser(browser);
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("I have input {string}")
    public void i_have_input(String emails) {
        WebElement input = driver.findElement(By.id("email"));

        if (emails.equals("noEmail")) {
            input.sendKeys("");
        } else {
            input.sendKeys("lajos@hotmail.com");
        }

    }

    @Given("I have also input {string}")
    public void i_have_also_input(String username) {
        WebElement input = driver.findElement(By.id("new_username"));


        if (username.equals("100longUser")) {

            String result = RandomStringUtils.randomAlphabetic(105);

            WebElement user = driver.findElement(By.id("new_username"));
            user.sendKeys(result);
        } else if (username.equals("alredyUser")) {
            WebElement user = driver.findElement(By.id("new_username"));
            user.sendKeys(username);


        } else if (username.equals("validUser")) {


            String result = RandomStringUtils.randomAlphabetic(8);

            WebElement user = driver.findElement(By.id("new_username"));
            user.sendKeys(result);

        }
    }

    @Given("I have also input pasword {string}")
    public void i_have_input_pasword(String Ludde) {
        WebElement input = driver.findElement(By.id("new_password"));
        input.sendKeys(Ludde);
    }

    @When("I press signup")
    public void i_press_signup() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.id("create-account")));

        click(driver, By.id("create-account"));

    }

    @Then("the result should be {string} on the screen")
    public void the_result_should_be_on_the_screen(String message) {

        if (message.equals("Check your email")) {
            result = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3"));

        } else {
            result = driver.findElement(By.cssSelector(".invalid-error"));

        }

        assertEquals(message, result.getAttribute("innerText"));
        System.out.println(result.getAttribute("innerText") + " = " + message);

        driver.quit();


    }
}

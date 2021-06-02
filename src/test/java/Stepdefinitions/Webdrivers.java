package Stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdrivers {

    WebDriver driver;

    public WebDriver createBrowser(String browser) {

        System.setProperty("webdriver.chrome.driver", "C://selenium jars and drivers//drivers//chromedriver/chromedriver.exe");
        driver = new ChromeDriver();


        return driver;
    }
}

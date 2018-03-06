package com.markushennig.scraper.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HeadlessChrome {

    private static final String DRIVER_PATH = "C:\\DEV\\chromedriver.exe";

    private final static String FACEBOOK = "https://www.facebook.com/";
    private final static String USER = "";
    private final static String PW = "";
    private final static String SEARCH = "";

    final static Logger logger = LoggerFactory.getLogger(HeadlessFirefox.class);

    public final static ChromeDriver build(final String website) {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(website);
        return driver;
    }

    // get driver from https://chromedriver.storage.googleapis.com/
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = build(FACEBOOK);
        //System.out.println(driver.getPageSource());
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(USER);
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys(PW);
        WebElement button = driver.findElement(By.id("loginbutton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
        while (!isDisplayed(button))
        {
            Thread.sleep(3000);
            System.out.println("Element is not visible yet");
        }
        WebElement searchArea = driver.findElement(By.className("chat_sidebar"));
        searchArea.getText().contains(SEARCH);
        System.out.println(driver.getPageSource());
        //takeScreenshot(driver);

    }

    private static void takeScreenshot(final ChromeDriver driver) {
        Path tmpFile = driver.getScreenshotAs(OutputType.FILE).toPath();
        try {
            Files.copy(tmpFile, Paths.get("screenshot.png"));
        } catch (IOException e) {
            logger.error("Saving Screenshot failed. Path=" + tmpFile);
        } finally {
            driver.quit();
        }
    }
    public static boolean isDisplayed(WebElement element) {
        try {
            if(element.isDisplayed())
                return element.isDisplayed();
        }catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }


}

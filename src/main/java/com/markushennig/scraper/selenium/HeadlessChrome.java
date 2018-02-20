package com.markushennig.scraper.selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HeadlessChrome {

    private static final String DRIVER_PATH = "C:\\DEV\\chromedriver.exe";

    final static Logger logger = LoggerFactory.getLogger(HeadlessFirefox.class);

    public static ChromeDriver build(String website){
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(website);
        return driver;
    }

    // get driver from https://chromedriver.storage.googleapis.com/
    public static void main(String[] args) {
        ChromeDriver driver = build("https://www.google.de");
        //System.out.println(driver.getPageSource());
        Path tmpFile = driver.getScreenshotAs(OutputType.FILE).toPath();
        try {
            Files.copy(tmpFile, Paths.get("screenshot.png"));
        } catch (IOException e) {
            logger.error("Saving Screenshot failed. Path=" + tmpFile);
        } finally {
            driver.quit();
        }
    }

}

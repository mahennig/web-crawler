package com.markushennig.scraper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HeadlessFirefox {

    final static Logger logger = LoggerFactory.getLogger(HeadlessFirefox.class);

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\DEV\\gecko.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.de");
        System.out.println(driver.getPageSource());

        Path tmpFile = driver.getScreenshotAs(OutputType.FILE).toPath();
        try {
            Files.copy(tmpFile, Paths.get("screenshot.png"));
        } catch (IOException e) {
            logger.error("Saving Screenshot failed. Path=" +tmpFile);
        }
    }
}

package com.markushennig.scraper;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeadlessChrome {

    final static Logger logger = LoggerFactory.getLogger(HeadlessFirefox.class);

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\DEV\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.de");
        System.out.println(driver.getPageSource());
    }

}

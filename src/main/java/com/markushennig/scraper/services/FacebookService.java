package com.markushennig.scraper.services;

import com.markushennig.scraper.selenium.HeadlessChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookService {

    private final static String FACEBOOK = "https://www.facebook.com/";

    public boolean isOnline(String name) {
        ChromeDriver driver = HeadlessChrome.build(FACEBOOK);
        WebElement element = driver.findElement(By.id(""));
        driver.findElement(By.cssSelector("button.radius")).click();

        return false;
    }


}

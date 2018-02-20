package com.markushennig.scraper.services;

import com.markushennig.scraper.selenium.HeadlessChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookService {

    public boolean isOnline(String name){
        ChromeDriver driver = HeadlessChrome.build("facebook.com");
        WebElement element = driver.findElement(By.id(""));
        driver.findElement(By.cssSelector("button.radius")).click();

        return false;
    }




}

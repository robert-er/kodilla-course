package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELDNAME = "q";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        assert driver != null;
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.name(SEARCHFIELDNAME));
        searchField.sendKeys("Kodilla");
        searchField.submit();
        searchField.submit();
    }
}

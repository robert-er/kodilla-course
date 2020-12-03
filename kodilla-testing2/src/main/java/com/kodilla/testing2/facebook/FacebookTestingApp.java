package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_COOKIE_ACCEPT_BUTTON = "//button[@data-cookiebanner=\"accept_button\"]";
    public static final String XPATH_CREATE_ACCOUNT_BUTTON = "//div[contains(@class, \"_6ltg\")]/a[contains(@class, \"_4jy2\")]";

    public static final String XPATH_DAY_FULL = "//html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[1]";
    public static final String XPATH_MONTH_FULL = "//html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[2]";
    public static final String XPATH_YEAR_FULL = "//html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select[3]";

    private final static String XPATH_PASSWORD_INPUT = "//html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[4]/div/div[1]/input";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        assert driver != null;
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_COOKIE_ACCEPT_BUTTON)).isDisplayed());

        WebElement cookieButton = driver.findElement(By.xpath(XPATH_COOKIE_ACCEPT_BUTTON));
        cookieButton.click();

        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT_BUTTON));
        createAccountButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!driver.findElement(By.xpath(XPATH_PASSWORD_INPUT)).isDisplayed());

        Select daySelectBox = new Select(driver.findElement(By.xpath(XPATH_DAY_FULL)));
        Select monthSelectBox = new Select(driver.findElement(By.xpath(XPATH_MONTH_FULL)));
        Select yearSelectBox = new Select(driver.findElement(By.xpath(XPATH_YEAR_FULL)));

        daySelectBox.selectByValue("10");
        monthSelectBox.selectByValue("7");
        yearSelectBox.selectByValue("1999");
    }
}

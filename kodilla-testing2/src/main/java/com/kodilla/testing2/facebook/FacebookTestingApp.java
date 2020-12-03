package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_INPUT_TITLE = "//html/body/main/section/form/fieldset/input";
    public static final String XPATH_INPUT_COMMENT = "//html/body/main/section/form/fieldset[2]/textarea";
    public static final String XPATH_WAIT_FOR = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";


    public static final String XPATH_COOKIE_ACCEPT_BUTTON = "//button[@data-cookiebanner=\"accept_button\"]";
    public static final String XPATH_CREATE_ACCOUNT_BUTTON = "//div[contains(@class, \"_6ltg\")]/a[contains(@class, \"_4jy2\")]";
    public static final String XPATH_SIGNUP_FORM = "//*[@id=\"reg_form_box\"]";
    public static final String XPATH_FORM_NAME = "//input[@name=\"firstname\"]";
    public static final String XPATH_SELECT_BIRTHDAY = "//*[@name=\"birthday_month\"]";

    public static final String XPATH_DAY_SELECT = "//div[@id=\"birthday_wrapper\"]/div[2]/span/span/select[1]";
    public static final String XPATH_MONTH_SELECT = "//div[@id=\"birthday_wrapper\"]/div[2]/span/span/select[2]";
    public static final String XPATH_YEAR_SELECT = "//div[@id=\"birthday_wrapper\"]/div[2]/span/span/select[3]";

    public static final String WEBSUBMIT = "select[id=\"month\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        assert driver != null;
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_COOKIE_ACCEPT_BUTTON)).isDisplayed());

        WebElement cookieButton = driver.findElement(By.xpath(XPATH_COOKIE_ACCEPT_BUTTON));
        cookieButton.click();


        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT_BUTTON));
        createAccountButton.click();

     //   while (!driver.findElement(By.xpath(XPATH_SIGNUP_FORM)).isDisplayed());

    //    WebElement firstName = driver.findElement(By.xpath(XPATH_FORM_NAME));
   //     firstName.sendKeys("Robert");

    //    while (!driver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY)).isDisplayed());

    //   WebElement selectBirthDay = driver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY));
    //   Select selectDay = new Select(selectBirthDay);
    //   selectDay.selectByValue("20");

        while(!driver.findElement(By.cssSelector(WEBSUBMIT)).isDisplayed());

        Select daySelectBox = new Select(driver.findElement(By.xpath(XPATH_DAY_SELECT)));
        Select monthSelectBox = new Select(driver.findElement(By.xpath(XPATH_MONTH_SELECT)));
        Select yearSelectBox = new Select(driver.findElement(By.xpath(XPATH_YEAR_SELECT)));


        daySelectBox.selectByValue("13");
        monthSelectBox.selectByVisibleText("cze");
        yearSelectBox.selectByValue("2000");

    }

}

package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormLogin {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createDriver(Platforms.android);
        try {
            LoginPage loginPage = new LoginPage(appiumDriver);
            loginPage.navMenuComponent().selectLogin();
            loginPage.loginComponent().inputEmail("ngan.nguyen@gmail.com");
            loginPage.loginComponent().inputPassword("12345678");
            loginPage.loginComponent().clickLogin();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}

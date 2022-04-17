package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormLogin {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createDriver(Platforms.android);
        try {
            MobileElement menuLoginElement = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            menuLoginElement.click();

            MobileElement txtUsernameElement = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement txtPasswordElement = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement btnLoginElement = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            txtUsernameElement.sendKeys("ngan.nguyen@gmail.com");
            txtPasswordElement.sendKeys("12345678");
            btnLoginElement.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            WebElement loginDialogTitleElem = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            System.out.println("Alert title: " + loginDialogTitleElem.getText());
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}

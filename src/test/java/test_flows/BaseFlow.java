package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;

public class BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void gotoLoginPage(){
        LoginPage loginPage = new LoginPage(this.appiumDriver);
        loginPage.navMenuComponent().selectLogin();
    }
}

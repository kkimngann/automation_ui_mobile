package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createDriver(Platforms.android);
        Map<String, String> mapLoginInfo = new HashMap<>();
        mapLoginInfo.put("ngan@", "12345678");
        mapLoginInfo.put("ngan.nguyen@gmail.com", "1234");
        mapLoginInfo.put("ngan.nguyen_2@gmail.com", "12345678");
        try {
            for (String email : mapLoginInfo.keySet()){
                loginWithInfo(appiumDriver, email, mapLoginInfo.get(email));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }

    private static void loginWithInfo(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        LoginFlow loginFlow = new LoginFlow(appiumDriver, email, password);
        loginFlow.gotoLoginPage();
        loginFlow.login();
        loginFlow.verifyLogin();
    }
}

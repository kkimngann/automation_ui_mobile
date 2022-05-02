package test.Authentication;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.models.LoginInfoData;
import test_flows.authentication.LoginFlow;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginInfoData")
    public void testLogin(LoginInfoData loginInfoData){
        String email = loginInfoData.getEmail();
        String password = loginInfoData.getPassword();
        loginWithInfo(appiumDriver, email, password);
    }

    @DataProvider
    public LoginInfoData[] loginInfoData() {
        String filePath = "/src/test/java/test_data/authentication/LoginInfo.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginInfoData[].class);
    }

    private static void loginWithInfo(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        LoginFlow loginFlow = new LoginFlow(appiumDriver, email, password);
        loginFlow.gotoLoginPage();
        loginFlow.login();
        loginFlow.verifyLogin();
    }
}

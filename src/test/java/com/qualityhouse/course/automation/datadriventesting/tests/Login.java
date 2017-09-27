package com.qualityhouse.course.automation.datadriventesting.tests;

import com.qualityhouse.course.automation.datadriventesting.pageobjects.CommonPageObjects;
import com.qualityhouse.course.automation.datadriventesting.pageobjects.LoginPageObject;
import com.qualityhouse.course.automation.datadriventesting.support.User;
import com.qualityhouse.course.automation.datadriventesting.support.Utils;
import org.junit.*;
import com.qualityhouse.course.automation.datadriventesting.testdata.LoginTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver = new ChromeDriver();

    private LoginPageObject loginPage = new LoginPageObject(driver);

    private CommonPageObjects common = new CommonPageObjects(driver);

    @Before
    public void setup() { common.openApplication(); }

    @After
    public void tearDown() { common.closeApplication(); }

    @Test
    public void tcLoginWithValidCredentials() {
        for (User user : LoginTestData.validUsers) {
            // so called "main test script"
            loginPage.open();
            loginPage.populateUsername(user.getUsername());
            loginPage.populatePassword(user.getPassword());
            loginPage.login();
            Utils.isPresent(driver, common.menuLogout);
            common.logout();
        }
    }

    @Test
    public void tcLoginWithInvalidCredentials() {
        for (User user : LoginTestData.invalidUsers) {
            // so called "main test script"
            loginPage.open();
            loginPage.populateUsername(user.getUsername());
            loginPage.populatePassword(user.getPassword());
            loginPage.login();
            Utils.isPresent(driver, common.menuLogin);
        }
    }

}

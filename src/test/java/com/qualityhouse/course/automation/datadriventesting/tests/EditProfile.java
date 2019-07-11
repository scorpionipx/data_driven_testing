package com.qualityhouse.course.automation.datadriventesting.tests;

import com.qualityhouse.course.automation.datadriventesting.pageobjects.CommonPageObjects;
import com.qualityhouse.course.automation.datadriventesting.pageobjects.EditProfilePageObject;
import com.qualityhouse.course.automation.datadriventesting.pageobjects.LoginPageObject;
import com.qualityhouse.course.automation.datadriventesting.support.User;
import com.qualityhouse.course.automation.datadriventesting.support.Utils;
import com.qualityhouse.course.automation.datadriventesting.testdata.EditProfileTestData;
import com.qualityhouse.course.automation.datadriventesting.testdata.LoginTestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditProfile {

    private WebDriver driver = new ChromeDriver();

    private LoginPageObject loginPage = new LoginPageObject(driver);

    private CommonPageObjects common = new CommonPageObjects(driver);

    private EditProfilePageObject editProfilePage = new EditProfilePageObject(driver);

    @Before
    public void setup() { common.openApplication(); }

    @After
    public void tearDown() {
        common.closeApplication();
    }

    @Test
    public void tcEditProfileWithValidData() {
        // todo: Exercise - create "main test script" for the valid modification of user's profile
        for (User user : EditProfileTestData.validUsers) {
            loginPage.open();
            loginPage.populateUsername(user.getUsername());
            loginPage.populatePassword(user.getPassword());
            loginPage.login();

            common.openEditProfilePage();

            editProfilePage.editProfile(user.getEmail(), user.getName(), user.getPhone(), user.getAddress());

            // do some verification

            common.logout();
        }
    }

    @Test
    public void tcEditProfileWithInvalidData() {
        // todo: Exercise - create "main test script" for the invalid modification of user's profile
        // hint: driver.switchTo().alert().dismiss()

    }

}

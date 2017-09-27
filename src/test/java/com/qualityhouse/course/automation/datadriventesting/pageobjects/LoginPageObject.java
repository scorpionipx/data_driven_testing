package com.qualityhouse.course.automation.datadriventesting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

    private WebDriver driver;

    public LoginPageObject (WebDriver driver) {
        this.driver = driver;
    }

    private CommonPageObjects common = new CommonPageObjects(driver);

    /* list of page components */

    public String loginPageURL = "?page=login";

    public By txtUsername = By.id("username");

    public By txtPassword = By.name("userpass");

    public By btnLogin = By.name("ses_login");


    /* list of page actions */

    public void open() {
        driver.get(common.applicationURL + loginPageURL);
    }

    public void populateUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void populatePassword(String pwd) {
        driver.findElement(txtPassword).sendKeys(pwd);
    }

    public void login() {
        driver.findElement(btnLogin).click();
    }

}

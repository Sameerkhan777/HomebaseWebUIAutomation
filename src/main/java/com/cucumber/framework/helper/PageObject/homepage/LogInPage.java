package com.cucumber.framework.helper.PageObject.homepage;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.PageObject.PageBase;
import com.cucumber.framework.settings.ObjectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;

public class LogInPage  extends PageBase {

    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(LogInPage.class);

    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /** Web Elements */

    @FindBy(xpath="//input[@placeholder='Email']")
    public WebElement usernameTxt;

    @FindBy(xpath="//input[@placeholder='Password']")
    public WebElement passwordTxt;

    @FindBy(xpath="//button[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath="//div[@id='error_explanation']/span")
    public WebElement errorMessageLabel;

    /** Public Methods  **/

    public WebDriver getDriver() {
        return this.driver;
    }

    public void logInToApplication(String username,String password) {
        waitForElement(usernameTxt,10);
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        signInButton.click();
        log.info("successfully  Logged in to the application ");
    }


    public void waitForUsernameTextBox()
    {
        waitForElement(usernameTxt,10);
    }



}

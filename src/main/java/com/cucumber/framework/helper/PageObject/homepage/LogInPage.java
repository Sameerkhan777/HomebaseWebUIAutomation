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

    @FindBy(xpath="//a[text()='here']")
    private WebElement linkToNavigateForgetPassword;

    @FindBy(xpath="//a[text()='Sign Up']")
    private WebElement signUpLink;

    @FindBy(xpath = "//span[contains(text(),'Do you own or manage a business?')]")
    private  WebElement setUpNewBusinessLink;

    @FindBy(xpath="//span[contains(text(),'your name?')]//following-sibling::div//input")
    private  WebElement userNameTextBox;

    @FindBy(xpath = "//span[@class='Select-arrow-zone']")
    private WebElement hearAboutUsDownArrow;

    @FindBy(xpath = "//div[@class='Select-menu-outer']//div[contains(text(),'In the news')]")
    private WebElement optionToSelect;

    @FindBy(xpath="//span[text()='Get started']/ancestor::button")
    private WebElement getStartedBtn;

    @FindBy(xpath = "//span[text()='Continue']/ancestor::button")
    private WebElement continueBtn;

    @FindBy(xpath = "//input[@name='businessName']")
    private WebElement businessName;

    @FindBy(xpath = "//input[@name='businessZip']")
    private WebElement zipCodeWE;

    @FindBy(xpath = "//span[text()='One last step']/ancestor::button")
    private WebElement oneLastStepBtn;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailTextBoxSingUp;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextBoxSingUp;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneTextBoxSingUp;

    @FindBy(xpath = "//span[text()='Text me a link to the mobile app']/ancestor::label//input")
    private WebElement textMobileLinkCheckbox;

    @FindBy(xpath = "//span[text()='Continue to Homebase']/ancestor::button")
    private WebElement continueToHomeBaseBtn;

    @FindBy(xpath="//span[@class='js-inline-error']")
    public WebElement invalidZipErrorMessage;


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

    public void clickOnNavigateForgotPasswordFLowLink(){
        waitForElement(linkToNavigateForgetPassword,5);
        linkToNavigateForgetPassword.click();
    }

    public String verifyNavigationToForgotPasswordPage(){
        waitForPageLoad();
        return driver.getTitle();
    }

    public void clickOnSignUpLink(){
        waitForPageLoad();
        this.signUpLink.click();
    }

    public void clickOnSetUpNewBusinessLink(){
        waitForPageLoad();
        this.setUpNewBusinessLink.click();
    }

    public void enterUserName(String username)
    {
        waitForPageLoad();
        this.userNameTextBox.sendKeys(username);
    }

    public void selectHowDidYouHearAboutUs(String optionToSelect) throws InterruptedException {
        this.hearAboutUsDownArrow.click();
        Thread.sleep(1000);
        this.optionToSelect.click();
        Thread.sleep(3000);
    }

    public void clickOnGetStartedBtn()
    {
        this.getStartedBtn.click();
    }

    public void whatBringsYouToHomeBase(String optionsToSelect) throws InterruptedException {
        waitForPageLoad();
        String[] options = optionsToSelect.split(",");
        for(String tempStr: options) {
            WebElement optionToSelectWE = driver.findElement(By.xpath("//span[contains(text(),'"+ tempStr +"')]"));
            optionToSelectWE.click();
            Thread.sleep(1000);
        }
    }

    public void howYouCurrentlyRunPayroll(String optionToSelect) throws InterruptedException {
        this.hearAboutUsDownArrow.click();
        Thread.sleep(1000);
        WebElement optionToSelectWE = driver.findElement(By.xpath("//div[@class='Select-menu-outer']//div[contains(text(),'"+optionToSelect+"')]"));
        optionToSelectWE.click();
    }

    public void clickContinueButton() throws InterruptedException {
        continueBtn.click();
        Thread.sleep(1000);
    }

    public void enterBusinessName(String strbusinessName){
        this.businessName.sendKeys(strbusinessName);
    }

    public void selectBusinessType(String strBusinessType) throws InterruptedException {
        this.hearAboutUsDownArrow.click();
        Thread.sleep(1000);
        WebElement optionToSelectWE = driver.findElement(By.xpath("//div[@class='Select-menu-outer']//div[contains(text(),'"+strBusinessType+"')]"));
        optionToSelectWE.click();
        Thread.sleep(1000);
    }

    public void clickBusinessTypeField() {
        this.hearAboutUsDownArrow.click();
    }

    public void enterZipCode(String strZipCode) throws InterruptedException {
        this.zipCodeWE.sendKeys(strZipCode);
        this.zipCodeWE.click();
        Thread.sleep(1000);
    }

    public void selectNumberOfEmployee(String strNoOfEmp) throws InterruptedException {
        WebElement optionToSelectWE = driver.findElement(By.xpath("//span[text()='"+strNoOfEmp+"']/ancestor::button"));
        optionToSelectWE.click();
        Thread.sleep(1000);
    }

    public void clickOneLastStepButton() throws InterruptedException {
        this.oneLastStepBtn.click();
        Thread.sleep(2000);
    }

    public void enterEmailAddress(String strEmailAddress) throws InterruptedException {
        waitForPageLoad();
        waitForElement(emailTextBoxSingUp,5);
        this.emailTextBoxSingUp.sendKeys(strEmailAddress);
        Thread.sleep(1000);
    }

    public void entersPassword(String strPassword) throws InterruptedException {
        this.passwordTextBoxSingUp.sendKeys(strPassword);
        Thread.sleep(1000);
    }

    public void enterPhoneNumber(String strPhoneNumber) throws InterruptedException {
        this.phoneTextBoxSingUp.sendKeys(strPhoneNumber);
        Thread.sleep(1000);
    }

    public void unCheckPhoneText() throws InterruptedException {
        this.textMobileLinkCheckbox.click();
        Thread.sleep(1000);
    }
    public void clickContinueToHomeBaseButton() throws InterruptedException {
        continueToHomeBaseBtn.click();
        Thread.sleep(10000);
    }

    public String getErrorMessageForInvalidZipCode(){
       return this.invalidZipErrorMessage.getText();
    }

}

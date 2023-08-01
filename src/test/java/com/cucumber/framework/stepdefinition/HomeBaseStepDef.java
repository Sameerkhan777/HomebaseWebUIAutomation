
package com.cucumber.framework.stepdefinition;


import com.cucumber.framework.helper.PageObject.homepage.LogInPage;
import org.testng.Assert;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.settings.ObjectRepo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomeBaseStepDef {
	
	private HomePage hPage;
	private LogInPage logInPage;


	@And("^: The title should be \"([^\"]*)\" search page$")
    public void _the_title_should_be_something_search_page(String title)
			throws Throwable {
		Assert.assertTrue(hPage.checkForTitle(title));
	}

	@Given("^User Launch application home page$")
	public void userLaunchApplicationHomePage() {
		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
		hPage = new HomePage(ObjectRepo.driver);
		logInPage = new LogInPage(ObjectRepo.driver);
		ObjectRepo.data.put("HomePage", hPage);
		ObjectRepo.data.put("loginPage", logInPage);
	}

	@When("User enters {string} username in Username field")
	public void userEntersUsernameInUsernameField(String userNameType) {
		logInPage.waitForUsernameTextBox();
		if(userNameType.equalsIgnoreCase("valid")) {
			logInPage.usernameTxt.sendKeys(ObjectRepo.reader.getUserName());
		}
		else{
			logInPage.usernameTxt.sendKeys("invalidusername@email.com");
		}
	}

	@And("User enters {string} password in password field")
	public void userEntersPasswordInPasswordField(String passType) throws InterruptedException {
		Thread.sleep(2000);
		if(passType.equalsIgnoreCase("valid")) {
			logInPage.passwordTxt.sendKeys(ObjectRepo.reader.getPassword());
		}else{
			logInPage.passwordTxt.sendKeys("password");
		}

	}

	@Then("user click on sign In Page button for {string} credentials")
	public void userClickOnSignInPage(String credentialsType) throws InterruptedException {
		Thread.sleep(2000);
		logInPage.signInButton.click();
		if(credentialsType.equalsIgnoreCase("valid")) {
			Thread.sleep(10000);
		}
		else{
			Thread.sleep(3000);
		}

	}

	@Then("User validates error message for invalid credentials")
	public void userVerifyErrorMessageForInvalidCredentialsOnSignInPage()  {
		Assert.assertTrue(logInPage.errorMessageLabel.getText().contains("Invalid email or password. Click"));
	}

	@And("User click on link to navigate the forget password flow")
	public void userClickOnLinkToNavigateForgetPassword() throws InterruptedException {
		logInPage.clickOnNavigateForgotPasswordFLowLink();
		Thread.sleep(2000);
		Assert.assertTrue(logInPage.verifyNavigationToForgotPasswordPage().contains("Homebase - Reset your password"));
	}

	@When("User click on sign up link on home page")
	public void userClickOnSignUpLinkOnHomePage() throws InterruptedException {
		logInPage.clickOnSignUpLink();
		Thread.sleep(2000);
	}

	@And("User click on Set up a new business link")
	public void userClickOnSetUpANewBusinessLink() throws InterruptedException {
		logInPage.clickOnSetUpNewBusinessLink();
		Thread.sleep(2000);
	}


	@Then("User enters {string} username in the Username field")
	public void userEnterUserName(String userName) throws InterruptedException {
		logInPage.enterUserName(userName);
		Thread.sleep(2000);
	}


	@And("User select {string} from the dropdown list")
	public void userSelectHowDidYouHearAboutUs(String optionToSelect)  throws InterruptedException {
		logInPage.selectHowDidYouHearAboutUs(optionToSelect);
	}

	@Then("User click on Get Started button")
	public void userClickOnGetStartedButton() throws InterruptedException {
		logInPage.clickOnGetStartedBtn();
	}

	@And("User select {string} options")
	public void userSelectWhatBringYouToHomeBase(String optionToSelect) throws InterruptedException {
		logInPage.whatBringsYouToHomeBase(optionToSelect);
	}


	@Then("User select {string} from the dropdown list for payroll")
	public void userSelectHowDoYouRunPayroll(String optionToSelect) throws InterruptedException {
		logInPage.howYouCurrentlyRunPayroll(optionToSelect);
	}


	@And("User click on Continue button")
	public void userClickOnContinueButton() throws InterruptedException {
		logInPage.clickContinueButton();
	}

	@When("User enters {string} in the business name field")
	public void userEntersBusinessName(String strBusinessName) throws InterruptedException {
		logInPage.enterBusinessName(strBusinessName);
	}

	@Then("User enters {string} in the zip code field")
	public void userEntersZipCode(String strZipCode) throws InterruptedException {
		logInPage.enterZipCode(strZipCode);
	}

	@Then("User select {string} from the list")
	public void userSelectNumberOfEmployee(String strNoOfEmployee) throws InterruptedException {
		logInPage.selectNumberOfEmployee(strNoOfEmployee);
	}

	@Then("User select {string} from the dropdown list for business type")
	public void userSelectBusinessType(String strBusinessType) throws InterruptedException {
		logInPage.selectBusinessType(strBusinessType);
	}

	@When("User click One Last step button")
	public void userClickOneLastStepButton() throws InterruptedException {
		logInPage.clickOneLastStepButton();
	}

	@Then("User enters {string} in the email address field")
	public void userEntersEmail(String strEmail) throws InterruptedException {
		logInPage.enterEmailAddress(strEmail);
	}

	@And("User enters {string} in the password field")
	public void userEntersPassword(String strPassword) throws InterruptedException {
		logInPage.entersPassword(strPassword);
	}

	@Then("User enters {string} in the phone number field")
	public void userEntersPhoneNumber(String strPhoneNumber) throws InterruptedException {
		logInPage.enterPhoneNumber(strPhoneNumber);
	}

	@When("User uncheck text me a link to the mobile app")
	public void userUncheckTextMeALinkToTheMobileApp() throws InterruptedException {
		logInPage.unCheckPhoneText();
	}

	@Then("User click on continue to Homebase")
	public void userClickOnContinueToHomebase() throws InterruptedException {
		logInPage.clickContinueToHomeBaseButton();
	}

	@Then("User validate error message {string} for invalid zip code entered")
	public void validateErrorMessageForInvalidZipCode(String errorMessageZip){
		Assert.assertEquals(logInPage.getErrorMessageForInvalidZipCode(),errorMessageZip);
	}

	@Then("User enters invalid {string} in the zip code field")
	public void userEntersInvalidZipCode(String strZipCode) throws InterruptedException {
		logInPage.enterZipCode(strZipCode);
		logInPage.clickBusinessTypeField();
	}
}



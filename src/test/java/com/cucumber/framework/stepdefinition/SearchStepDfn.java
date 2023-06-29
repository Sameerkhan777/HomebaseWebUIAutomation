
package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.helper.InitializeWebDrive;
import com.cucumber.framework.helper.PageObject.homepage.LogInPage;
import org.testng.Assert;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.settings.ObjectRepo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class SearchStepDfn {
	
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
		ObjectRepo.data.put("HomePage", hPage);
	}

	@When("User enters {string} username in Username field")
	public void userEntersUsernameInUsernameField(String userNameType) {
		logInPage = new LogInPage(ObjectRepo.driver);
		logInPage.waitForUsernameTextBox();
		ObjectRepo.data.put("LoginPage", logInPage);
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




}

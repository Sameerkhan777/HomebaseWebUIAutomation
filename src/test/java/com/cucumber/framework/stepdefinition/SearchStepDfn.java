
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

	@When("User enters username in Username field")
	public void userEntersUsernameInUsernameField() {
		logInPage = new LogInPage(ObjectRepo.driver);
		logInPage.waitForUsernameTextBox();
		ObjectRepo.data.put("LoginPage", logInPage);
		logInPage.usernameTxt.sendKeys(ObjectRepo.reader.getUserName());
	}

	@And("User enters password in password field")
	public void userEntersPasswordInPasswordField() throws InterruptedException {
		Thread.sleep(5000);
		logInPage.passwordTxt.sendKeys(ObjectRepo.reader.getPassword());
	}

	@Then("user click on sign In Page button")
	public void userClickOnSignInPage() throws InterruptedException {
		Thread.sleep(2000);
		logInPage.signInButton.click();;
		Thread.sleep(15000);
	}




}

package com.cucumber.framework.helper;

import com.cucumber.framework.configreader.PropertyFileReader;
import com.cucumber.framework.configuration.browser.*;
import com.cucumber.framework.exception.NoSutiableDriverFoundException;
import com.cucumber.framework.helper.Generic.GenericHelper;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.settings.ObjectRepo;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class InitializeWebDrive {

	private Logger oLog = LoggerHelper.getLogger(InitializeWebDrive.class);

	public InitializeWebDrive(PropertyFileReader reader) {
		ObjectRepo.reader = reader;
	}

	public InitializeWebDrive(){

	}

	public WebDriver standAloneStepUp(BrowserType bType) throws Exception {
		try {
			oLog.info(String.valueOf(bType));

			switch (bType) {

			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver();

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver();
			default:
				throw new NoSutiableDriverFoundException(" Driver Not Found : "
						+ bType);
			}
		} catch (Exception e) {
			oLog.equals(e);
			throw e;
		}
	}
	
	@Before("~@firefox,~@chrome,~@iexplorer")
	public void before() throws Exception {
		setUpDriver(BrowserType.Chrome);
		oLog.info(BrowserType.Chrome.toString());
	}

	@After("~@firefox,~@chrome,~@phantomjs,~@iexplorer")
	public void after(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}
	
	@Before(order=4,value="@iexplorer")
	public void beforeExplorer() throws Exception {
		setUpDriver(BrowserType.Iexplorer);
		oLog.info(String.valueOf(BrowserType.Iexplorer));
	}

	@After(order=4,value="@iexplorer")
	public void afterExplorer(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order=3,value="@firefox")
	public void beforeFirefox() throws Exception {
		setUpDriver(BrowserType.Firefox);
		oLog.info("Just to verify the Logs");
		oLog.info(String.valueOf(BrowserType.Firefox));
	}

	@After(order=3,value="@firefox")
	public void afterFirefox(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order=2,value="@chrome")
	public void beforeChrome() throws Exception {
		setUpDriver(BrowserType.Chrome);
		oLog.info(String.valueOf(BrowserType.Chrome));
	}

	@After(order=2,value="@chrome")
	public void afterChrome(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}



	public void setUpDriver(BrowserType bType) throws Exception {
		ObjectRepo.reader = new PropertyFileReader();
		ObjectRepo.driver = standAloneStepUp(bType);
		oLog.debug("InitializeWebDrive : " + ObjectRepo.driver.hashCode());
		ObjectRepo.driver
				.manage()
				.timeouts()
				.pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),
						TimeUnit.SECONDS);
		ObjectRepo.driver
				.manage()
				.timeouts()
				.implicitlyWait(ObjectRepo.reader.getImplicitWait(),
						TimeUnit.SECONDS);
		ObjectRepo.driver.manage().window().maximize();

	}

	public void tearDownDriver(Scenario scenario) throws Exception {
		try {
			if (ObjectRepo.driver != null) {
				
				if(scenario.isFailed()) {
					byte[] screenshot = ((TakesScreenshot) ObjectRepo.driver).getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshot, "image/png",scenario.getName());
					//scenario.log(new GenericHelper(ObjectRepo.driver).takeScreenShot(scenario.getName()));
				}
			}
		} catch (Exception e) {
			oLog.error(e.getMessage());
			throw e;
		}
		finally {
			ObjectRepo.driver.quit();
			ObjectRepo.reader = null;
			ObjectRepo.driver = null;
			oLog.info("Shutting Down the driver");
		}
	}

}

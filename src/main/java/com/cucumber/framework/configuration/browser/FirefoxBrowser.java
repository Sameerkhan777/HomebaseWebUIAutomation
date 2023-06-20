/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.cucumber.framework.configuration.browser;

import com.cucumber.framework.utility.ResourceHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class FirefoxBrowser {

	
	public WebDriver getFirefoxDriver() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("start-maximized");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		return driver;
	}
	
	public WebDriver getFirefoxDriver(String hubUrl,Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl),cap);
	}

}

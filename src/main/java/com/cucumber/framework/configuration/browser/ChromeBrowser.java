
package com.cucumber.framework.configuration.browser;

import com.cucumber.framework.utility.DateTimeHelper;
import com.cucumber.framework.utility.ResourceHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class ChromeBrowser {


	public WebDriver getChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(chromeOptions);
		return driver;
	}
	
	public WebDriver getChromeDriver(String hubUrl,Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl), cap);
	}

}

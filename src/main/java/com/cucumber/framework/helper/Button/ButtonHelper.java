package com.cucumber.framework.helper.Button;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.interfaces.IwebComponent;
import org.slf4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ButtonHelper implements IwebComponent {
	
	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(ButtonHelper.class);
	
	public ButtonHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("Button Helper : " + this.driver.hashCode());
	}
	
	public void click(By locator) {
		click(driver.findElement(locator));
		oLog.info(String.valueOf(locator));
	}
	
	public void click(WebElement element){
		element.click();
		oLog.info(String.valueOf(element));
	}
}


package com.cucumber.framework.configreader;

import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.interfaces.IconfigReader;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class PropertyFileReader implements IconfigReader {
	
	private Properties prop ;

	public PropertyFileReader() {
		prop = new Properties();

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("configfile/config.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getWebsite() {
		return prop.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}
	
	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DtaBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}
	


}

package com.cucumber.framework.helper.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class clas) {
		if(root)
			return LoggerFactory.getLogger(clas);
		root = true;
		return LoggerFactory.getLogger(clas);
	}

}

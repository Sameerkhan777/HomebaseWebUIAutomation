
package com.cucumber.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;


public class ResourceHelper {

	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath(resource);
		return path;
	}
	
	public static String getBaseResourcePath(String resource) {
		ResourceHelper rsHelp = new ResourceHelper();
		String path = "";
				//rsHelp.getClass().getResource("/").getPath();

		try {
			path = rsHelp.getFileFromResource(resource);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String resource) throws FileNotFoundException {
		return new FileInputStream(ResourceHelper.getResourcePath(resource));
	}

	private  String getFileFromResource(String fileName) throws URISyntaxException {

		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {

			// failed if files have whitespaces or special characters
			String temp =  new File(resource.getFile()).getAbsolutePath();

			return (resource.toURI().toString());
		}

	}
	
}

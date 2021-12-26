package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFileUtil {
	
	public Properties prop;
		
	public Properties readProperties(String filePath) {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream(filePath);
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}

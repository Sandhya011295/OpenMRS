package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManagerMRS {
	private static Properties property;
	private static FileInputStream fileInputStream;
	
	private static void setupProperty() throws IOException {
		if (property == null) {
		File file = new File("C:\\Users\\USER\\eclipse-workspace\\OctoberProject\\src\\main\\java\\com\\property\\TestData.properties");	
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR : FILNOTFOUND EXCEPTION OCCURE DURING PROPERTY FILE LOADING");
		}catch (Exception e) {
			Assert.fail("ERROR : FILNOTFOUND EXCEPTION OCCURE DURING PROPERTY FILE LOADING");
		}
		}
	}
	public static String getDataProperty(String dataValue) throws Throwable {
		setupProperty();
		String browsername = property.getProperty(dataValue);
		return browsername;
	}

}

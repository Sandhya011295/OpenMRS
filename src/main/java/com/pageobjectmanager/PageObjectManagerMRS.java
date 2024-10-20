package com.pageobjectmanager;

import com.base.Base_Class;
import com.property.FileReaderManagerMRS;

import pageobjectmodel.OpenMrsLoginPage;


public class PageObjectManagerMRS extends Base_Class {
	private OpenMrsLoginPage loginPage;
	private FileReaderManagerMRS fileReader;
	
	
	public OpenMrsLoginPage getLoginPage() {
		
		if (loginPage == null) {
		loginPage = new OpenMrsLoginPage(driver);
		}
		return loginPage;
	}
	public FileReaderManagerMRS getFileReader() {
		if (fileReader == null) {
			fileReader = new FileReaderManagerMRS();
		}
		return fileReader;
	}
	

}

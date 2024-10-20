package com.pageobjectmanager;


import com.base.Base_Class;
import com.property.FileReaderManager;

import pageobjectmodel.AdactinLoingPage;

public class PageObjectManager extends Base_Class{

	private AdactinLoingPage loginPage;
	private FileReaderManager fileReader;
	
	
	public AdactinLoingPage getLoginPage() {
		
		if (loginPage == null) {
		loginPage = new AdactinLoingPage(driver);
		}
		return loginPage;
	}
	public FileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
	}
	
	
	
}

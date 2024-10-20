package com.testng;

import org.testng.annotations.Test;

import com.base.Base_Class;

public class InvocationCount extends Base_Class{
	@Test(invocationCount = 4)
	private void launchBrowser() {
        launchBroswer("Chrome");
	}

}

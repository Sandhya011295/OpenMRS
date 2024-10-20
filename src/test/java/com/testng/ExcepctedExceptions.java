package com.testng;

import org.testng.annotations.Test;

import com.base.Base_Class;

public class ExcepctedExceptions extends Base_Class {
	@Test(expectedExceptions = ArithmeticException.class)
	private void exception() {
		
		launchBroswer("chrome");
		launchUrl("https://www.google.co.in/");
		int i = 10/0;
		System.out.println("Browser Launched");

	}

}

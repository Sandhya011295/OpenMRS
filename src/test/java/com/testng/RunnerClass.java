package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RunnerClass {
	
	@Test
	public void setup() {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.google.com/");
	


	}

}

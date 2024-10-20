package com.testng;


import org.testng.annotations.Test;
import com.base.Base_Class;

public class CrossBroswerTesting extends Base_Class{
	@Test(priority =2)
	private void chrome() {
		launchBroswer("chrome");
		launchUrl("https://www.google.co.in/");
		System.out.println("Broswer ID:" +Thread.currentThread().getId());
		closebroswer();
	}
	@Test (priority =-2)
	private void edge() {
		launchBroswer("edge");
		launchUrl("https://www.google.co.in/");
		System.out.println("Broswer ID:" +Thread.currentThread().getId());
		closebroswer();
	}

}

package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class DataProviderTest extends Base_Class{
	@Test(dataProvider = "login")
	private void login(String username, String password) {
		
		launchBroswer("Chrome");
		launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();

	}
@DataProvider(name = "login")

public Object [][] dataset(){
	
	return new Object[][]
			{{"Admin","admin123"},{"abcd","adn123"},{"vvcdd","123"},{"ddd","ddd123"},{"",""}};
}



}


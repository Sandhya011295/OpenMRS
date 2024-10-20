package com.testng;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.Base_Class;

public class Parameter extends Base_Class{
		
		@Test
		@Parameters({"username","password"})
		private void login(String username, String password) {
			
			launchBroswer("Chrome");
			launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();

	}
	}



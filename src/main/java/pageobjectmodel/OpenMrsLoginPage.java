package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base_Class;
import com.interfaceelement.OpenMRSElements;
import com.property.FileReaderManagerMRS;

public class OpenMrsLoginPage extends Base_Class implements OpenMRSElements {

	@FindBy(id = userName_id)
	private WebElement username;

	@FindBy(id = password_id)
	private WebElement password;

	@FindBy(id = location_id)
	private WebElement location;

	@FindBy(id = login_id)
	private WebElement login;

	public OpenMrsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}

	public boolean validLogin(ExtentTest extenttext) throws Throwable {

		try {

			FileReaderManagerMRS data = new FileReaderManagerMRS();
			launchUrl(data.getDataProperty("url"));
			passInput(username, data.getDataProperty("loginusername"));
			passInput(password, data.getDataProperty("longinpassword"));
			elementClick(location);
			elementClick(login);
			validation(driver.getTitle(), data.getDataProperty("title"));
			extenttext.log(Status.PASS, "Login Sucessful");
		} catch (AssertionError e) {
			extenttext.log(Status.FAIL, "LoginFailed" + e.getMessage());
			return false;
		}

		return true;
	}
}

	
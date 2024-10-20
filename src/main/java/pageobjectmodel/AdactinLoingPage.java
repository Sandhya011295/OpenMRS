package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.AdactinApplicationElements;
import com.property.FileReaderManager;

public class AdactinLoingPage extends Base_Class implements AdactinApplicationElements {
	
	@FindBy(id = username_id)
	
	private WebElement username;
	
	@FindBy(id = password_id)
	private WebElement password;
	
	@FindBy(xpath = login_xpath)
	private WebElement login;
	
	
	public AdactinLoingPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	public void validUserNameAndValidPassword() throws Throwable {
		
	FileReaderManager data = new FileReaderManager();
	passInput(username, data.getDataProperty("loginusername"));
	passInput(password, data.getDataProperty("longinpassword"));
	elementClick(login);
	//validation(driver.getTitle(), data.getDataProperty("title"));
	}
	

}

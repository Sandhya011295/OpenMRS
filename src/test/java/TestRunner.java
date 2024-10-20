

import com.baseclass.Base_Class;
import com.baseclass.POM_Manager;

public class TestRunner extends Base_Class   {
	
	public static void main(String[] args) throws Exception, Throwable {
		
		com.baseclass.POM_Manager pageObjectManager= new POM_Manager();
		
		
		launchBrowser(pageObjectManager.getDataReader().getDataProperty("browser"));
		
		launchUrl(pageObjectManager.getDataReader().getDataProperty("url"));
		
		pageObjectManager.getLoginPage().loginPageActions();
		
	}
	

}

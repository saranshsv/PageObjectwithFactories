package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.HomePage;

public class SignInTest {

	@Test
	public void signIntest (){
		Page.initConfiguration();
		HomePage page=new HomePage();
		page.signInPopup("abc@gmail.com", "xyzserd");
		Page.quitBrowser();

	}

}

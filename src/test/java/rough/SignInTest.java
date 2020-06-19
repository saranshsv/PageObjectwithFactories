package rough;

import base.Page;
import pages.actions.HomePage;

public class SignInTest {

	public static void main(String[] args) {
		Page.initConfiguration();
		HomePage page=new HomePage();
		page.signInPopup("abc@gmail.com", "xyzserd");

	}

}

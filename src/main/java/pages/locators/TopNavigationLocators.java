package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {
	
	//Account Button
	@FindBy(xpath="//button[@id='header-account-menu']")
	public WebElement accountBtn;
	
	//SignIn Button
	@FindBy(xpath="//a[@id='account-signin']")
	public WebElement signInBtn;
	
	//createAccount Button
	@FindBy(xpath="//a[@id='account-register']")
	public WebElement createAccountBtn;
	
}

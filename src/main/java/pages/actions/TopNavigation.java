package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import pages.locators.TopNavigationLocators;

public class TopNavigation {
	
	public TopNavigationLocators topNavigation;
	public TopNavigation(WebDriver driver) {
		this.topNavigation=new TopNavigationLocators();
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.topNavigation);
	}
	public void gotoSignIn() {
		topNavigation.accountBtn.click();
		topNavigation.signInBtn.click();
	}
	public void gotoCreateAccount() {
		topNavigation.createAccountBtn.click();
	}
}

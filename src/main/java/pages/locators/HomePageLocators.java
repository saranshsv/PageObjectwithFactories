package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	//Locator of Flight Tab
	@FindBy(xpath="//a[contains(text(),'flights')]")
	public WebElement flightTab;
	
	//Locator of Round Trip Tab
	@FindBy(xpath="//div[contains(text(),'Round Trip')]")
	public WebElement roundTrip;
	
	//Locators for Flight booking
	@FindBy(xpath="//div[@class='form-fields']/div/div/div/div[contains(text(),'From')]/following-sibling::input[@class='c-input u-v-align-middle']")
	public WebElement fromCity;
	
	@FindBy(xpath="//div[@class='form-fields']/div/div/div/div[contains(text(),'To')]/following-sibling::input[@class='c-input u-v-align-middle']")
	public WebElement toCity;
	
	@FindBy(xpath="//div[@class='form-fields']/div/div/div/div/div[contains(text(),'Departure')]/following-sibling::input[@class='c-input u-v-align-middle']")
	public WebElement dDateTab;
	
	@FindBy(xpath="//div[contains(text(),'Return')]/following-sibling::input[@class='c-input u-v-align-middle']")
	public WebElement rDateTab;
	
	
	@FindBy(xpath="//div[contains(text(),'Adult')]/ancestor::div[1]/following-sibling::div/span[@data-val='\"+numOfAdults+\"']")
	public WebElement adultCount;
	
	@FindBy(xpath="//div[contains(text(),'Child')]/ancestor::div[1]/following-sibling::div/span[@data-val='\"+numOfChild+\"']")
	public WebElement childCount;
	
	@FindBy(xpath="//div[contains(text(),'Infant')]/ancestor::div[1]/following-sibling::div/span[@data-val='\"+numOfInfant+\"']")
	public WebElement infantCount;
	
	@FindBy(xpath="//button[@class='c-btn u-link enabled'][contains(text(),'Search')]")
	public WebElement search;
	
	@FindBy(xpath="//*[@id=\"wizardSection\"]/div[1]")
	public WebElement randomclick;
	
	//Sign In Pop Up
	@FindBy(xpath="//input[@id='gss-signin-email']")
	public WebElement emailEnter;
	
	@FindBy(xpath="//input[@id='gss-signin-password']")
	public WebElement passwordEnter;
	
	@FindBy(xpath="//button[@id='gss-signin-submit']")
	public WebElement signInSubmit;
}

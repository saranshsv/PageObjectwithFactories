package pages.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Page;
import pages.locators.HomePageLocators;

public class HomePage extends Page{
	
	public HomePageLocators home;
	public HomePage() {
		this.home=new HomePageLocators();
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.home);
	}
	
	public HomePage gotoFlights() {
		home.flightTab.click();
		return this;
	}
	public void gotoHotels() {
		
	}
	public void gotoFlightAndHotels() {
		
	}
	public void bookAFlight(String from,String to,String depdate,String retdate,String adults,String child,String infants) throws ParseException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		home.roundTrip.click();
		home.fromCity.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		home.fromCity.sendKeys(from);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.sendKeys(Keys.ENTER).perform();
		home.toCity.sendKeys(to);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.sendKeys(Keys.ENTER).perform();
		
		home.dDateTab.click();
		
		String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date mydate = df.parse(depdate);
		
		
		
		java.util.Calendar cal=java.util.Calendar.getInstance();
		cal.setTime(mydate);

		int day=cal.get(java.util.Calendar.DAY_OF_MONTH);
		int month=cal.get(java.util.Calendar.MONTH);
		int year=cal.get(java.util.Calendar.YEAR);
		
		String forwardArrow= "//button[@class='ixi-icon-arrow rd-next']";
		String travelMonth = months[month] +" "+year;

		String xpathMonthYearSection = "//div[@class='rd-date']/div[@class='rd-month']/div[@class='rd-month-label']";
		
		while(!driver.findElement(By.xpath(xpathMonthYearSection)).getText().equals(travelMonth)) {
			driver.findElement(By.xpath(forwardArrow)).click();
		}
		driver.findElement(By.xpath("//div[text()='" + day + "']")).click();
		
		home.rDateTab.click();
		
		//driver.findElement(By.xpath("//div[contains(text(),'Return')]/following-sibling::input[@class='c-input u-v-align-middle']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		df=new SimpleDateFormat("dd/MM/yyyy");
		mydate=df.parse(retdate);
		cal=java.util.Calendar.getInstance();
		cal.setTime(mydate);
		
		day=cal.get(java.util.Calendar.DAY_OF_MONTH);
		month=cal.get(java.util.Calendar.MONTH);
		year=cal.get(java.util.Calendar.YEAR); 
		
		forwardArrow= "//button[@class='ixi-icon-arrow rd-next']";
		travelMonth = months[month] +" "+year;
		

		xpathMonthYearSection = "//div[@class='rd-date']/div[@class='rd-month']/div[@class='rd-month-label']";
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div[contains(text(),'"+travelMonth+"')]/following-sibling::table/tbody/tr/td/div[contains(text(),'"+day+"')]"))).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Adult')]/ancestor::div[1]/following-sibling::div/span[@data-val='"+adults+"']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Child')]/ancestor::div[1]/following-sibling::div/span[@data-val='"+child+"']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Infant')]/ancestor::div[1]/following-sibling::div/span[@data-val='"+infants+"']")).click();
		home.search.click();
	}
	public void signInPopup(String email,String password){
		/*
		topNav.gotoSignIn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		home.emailEnter.sendKeys(email);
		home.passwordEnter.sendKeys(password);
		home.signInSubmit.click();*/
	}
}

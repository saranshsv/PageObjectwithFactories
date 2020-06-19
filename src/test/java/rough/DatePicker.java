package rough;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws ParseException {
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.findElement(By.xpath("//a[contains(text(),'flights')]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//div[contains(text(),'Round Trip')]")).click();
		driver.findElement(By.xpath("//div[@class='form-fields']/div/div/div/div[contains(text(),'From')]/following-sibling::input[@class='c-input u-v-align-middle']")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		
		driver.findElement(By.xpath("//div[@class='form-fields']/div/div/div/div[contains(text(),'From')]/following-sibling::input[@class='c-input u-v-align-middle']")).sendKeys("BOM - Mumbai");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//div[@class='form-fields']/div/div/div/div[contains(text(),'To')]/following-sibling::input[@class='c-input u-v-align-middle']")).sendKeys("HYD - Hyderabad");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//div[@class='form-fields']/div/div/div/div/div[contains(text(),'Departure')]/following-sibling::input[@class='c-input u-v-align-middle']")).click();
		 
        
		String d1="10/08/2020";
		String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date mydate=df.parse(d1);
		java.util.Calendar cal=java.util.Calendar.getInstance();
		cal.setTime(mydate);

		int day=cal.get(java.util.Calendar.DAY_OF_MONTH);
		int month=cal.get(java.util.Calendar.MONTH);
		int year=cal.get(java.util.Calendar.YEAR);

		System.out.println(day);
		System.out.println(month);
		System.out.println(months[month]);
		System.out.println(year);

		String forwardArrow= "//button[@class='ixi-icon-arrow rd-next']";
		String travelMonth = months[month] +" "+year;
		System.out.println(travelMonth);

		String xpathMonthYearSection = "//div[@class='rd-date']/div[@class='rd-month']/div[@class='rd-month-label']";
		
		
		while(!driver.findElement(By.xpath(xpathMonthYearSection)).getText().equals(travelMonth)) {
			driver.findElement(By.xpath(forwardArrow)).click();
		}
		
		driver.findElement(By.xpath("//div[text()='" + day + "']")).click(); //select desired date 
		
		
		driver.findElement(By.xpath("//div[contains(text(),'Return')]/following-sibling::input[@class='c-input u-v-align-middle']")).click();
		
		String d2="20/09/2020";
		
		df=new SimpleDateFormat("dd/MM/yyyy");
		mydate=df.parse(d2);
		cal=java.util.Calendar.getInstance();
		cal.setTime(mydate);
		
		day=cal.get(java.util.Calendar.DAY_OF_MONTH);
		month=cal.get(java.util.Calendar.MONTH);
		year=cal.get(java.util.Calendar.YEAR); 
		
		System.out.println(day);
		System.out.println(month);
		System.out.println(months[month]);
		System.out.println(year);

		forwardArrow= "//button[@class='ixi-icon-arrow rd-next']";
		travelMonth = months[month] +" "+year;
		System.out.println(travelMonth);

		xpathMonthYearSection = "//div[@class='rd-date']/div[@class='rd-month']/div[@class='rd-month-label']";
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/div[contains(text(),'"+travelMonth+"')]/following-sibling::table/tbody/tr/td/div[contains(text(),'"+day+"')]"))).click();
		int numOfAdults = 5;
		int numOfChild = 3;
		int numOfInfant = 2;
		driver.findElement(By.xpath("//div[contains(text(),'Adult')]/ancestor::div[1]/following-sibling::div/span[@data-val='"+numOfAdults+"']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Child')]/ancestor::div[1]/following-sibling::div/span[@data-val='"+numOfChild+"']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Infant')]/ancestor::div[1]/following-sibling::div/span[@data-val='"+numOfInfant+"']")).click();
		driver.findElement(By.xpath("//button[@class='c-btn u-link enabled'][contains(text(),'Search')]")).click();
		
	}
}


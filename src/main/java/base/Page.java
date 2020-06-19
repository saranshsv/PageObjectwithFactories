package base;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.actions.TopNavigation;
import utilities.ExcelReader;
import utilities.ExtentManager;

public class Page {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopNavigation topNav;
	
	public static void initConfiguration() {
		if(Constants.browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver=new FirefoxDriver();
			log.debug("Launching Firefox browser!!!");
			
		}else if(Constants.browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			log.debug("Launching Chrome browser!!!");
			
		}else if(Constants.browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.debug("Launching IE browser!!!");
		}
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		/*driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,10);*/
		topNav=new TopNavigation(driver);
		
	}
	public static void quitBrowser() {
		driver.quit();
	}
}

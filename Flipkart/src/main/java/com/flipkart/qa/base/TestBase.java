package com.flipkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\pagid\\eclipse-workspace\\Flipkart\\src\\main\\java\\com\\flipkart\\qa\\configuration\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
}
public static void initialization() {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")){
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\pagid\\Desktop\\naveen 2\\chromedriver_win32\\chromedriver.exe");
         driver=new ChromeDriver();
		
	}
	 else if(browserName.equals("FF")) {
    	 
    	 System.setProperty("webdriver.gecko.driver","C:\\Users\\pagid\\Desktop\\naveen 2\\geckodriver-v0.29.1-win64\\geckodriver.exe");
         driver=new FirefoxDriver();
	 }

	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	     driver.get(prop.getProperty("url"));
}
	
	
	
	
	
}

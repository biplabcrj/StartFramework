package BaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	FileInputStream objfile;
	Properties obj;
	
	@BeforeTest
	public void setup()
	{
		Properties obj = new Properties();
		try {
			objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			obj.load(objfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String bowser = obj.getProperty("browser");
		String url = obj.getProperty("url");
		String time = obj.getProperty("globalTime");
		if(bowser.equals("chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(bowser.equals("firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(time), TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}


}

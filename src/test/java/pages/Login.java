package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	String userIdXpath = "//input[@name='uid']";
	String passwordXpath = "//input[@name='password']";
	String loginBtn = "//input[@name='btnLogin']";
	String loginReset = "//input[@name='btnReset']";
	
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method is used to provide details for login
	 * @param userid
	 * @param password
	 */
	public void login(String userid, String password)
	{
		driver.findElement(By.xpath(userIdXpath)).sendKeys(userid);
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
		driver.findElement(By.xpath(loginBtn)).click();
	}
	
	/**
	 * This method is used to provide details to check reset
	 * @param usrid
	 * @param password
	 */
	public void reset(String usrid, String password)
	{
		driver.findElement(By.xpath(userIdXpath)).sendKeys(usrid);
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
		driver.findElement(By.xpath(loginReset)).click();
	}

}

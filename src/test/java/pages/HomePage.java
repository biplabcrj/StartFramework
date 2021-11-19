package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	String customerXpath = "//a[text()='Manager']/parent::li/following-sibling::li[1]/a";
	String customerNameXpath = "";
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void customerFormFillUp()
	{
		
	}

}

package testScript;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {
	
	@Test
	public void switchWindow() throws InterruptedException
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/popup.php");
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();;
		
		//storing current window
		String currentwindow = driver.getWindowHandle();
		System.out.println("currect window: "+currentwindow);
		
		//stor all open window
		Set<String> allwindow = driver.getWindowHandles();
		System.out.println("all window: "+allwindow);
		
		for(String window:allwindow)
		{
			if(!window.equals(currentwindow))
			{
				driver.switchTo().window(window);
				boolean flag = driver.findElement(By.xpath("//h2[contains(.,'Enter your email address to get')]")).isDisplayed();
				System.out.println(flag);
				driver.findElement(By.name("emailid")).sendKeys("test@gmail.com");
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(currentwindow);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();;
	}

}

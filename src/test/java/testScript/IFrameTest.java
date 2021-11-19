package testScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameTest {

	@Test
	public void IFrameTest() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
		
		//Finding all iframe tags on a web page
		List<WebElement> elements = driver.findElements(By.tagName("frame"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
		
		// Switch to the frame using the index
		System.out.println("Switching to the frame");
		//driver.switchTo().frame(1);
		driver.switchTo().frame(driver.findElement(By.xpath( "//frame[@src='message.htm']")));
		
		driver.findElement(By.name("name")).sendKeys("testtt");
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.close();
	}

}

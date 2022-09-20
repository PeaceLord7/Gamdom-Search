package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class GamdomSearch {

	 public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("disable-extensions");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		String baseURL = null;
		baseURL = "https://gamdom.com/marketplace/P2P";
		driver.navigate().to(baseURL);
		
		driver.findElement(By.xpath("//a[@class='modal-close-button']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//button/i")).click();
		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    if(!winHandle.equalsIgnoreCase(winHandleBefore)) {
		    	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("****");
		    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("****");
		    	driver.findElement(By.xpath("//input[@type='submit']")).click();
		    	Thread.sleep(10000);
		    }
		}
		driver.switchTo().window(winHandleBefore);
		driver.navigate().to(baseURL);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		element.clear();
		for(int i=0;;i++) {
		element.sendKeys(",");
		Thread.sleep(5000);
		}
	  }
}

package NewTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAutomation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://jt-dev.azurewebsites.net/#/SignUp";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

		// Checking if English and Dutch are present
		driver.findElement(By.id("language")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//*[contains(text(),'English')]"));
		if (elementsList.isEmpty()) {
			System.out.println("English is not found");
		} else
			System.out.println("English is found");

		List<WebElement> elementsList1 = driver.findElements(By.xpath("//*[contains(text(),'Dutch')]"));
		if (elementsList1.isEmpty()) {
			System.out.println("Dutch is not found");
		} else
			System.out.println("Dutch is found");
			
		

		// Inserting values to the test fields
		driver.findElement(By.id("name")).sendKeys("Name");
		driver.findElement(By.id("orgName")).sendKeys("My Organization");
		driver.findElement(By.id("singUpEmail")).sendKeys("name_aug28_01@yopmail.com");
		driver.findElement(By.xpath("//*[contains(text(),'I agree to the')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Get Started')]")).click();
				
		
		
		//Validating email
		String baseUrl1 = "http://yopmail.com";
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("name_aug28_01");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		List<WebElement> elementsList2 = driver.findElements(By.xpath("//*[contains(text(),'Name!')]"));
		if (elementsList2.isEmpty()) {
			System.out.println("Email sent and validated");
		} else
			System.out.println("Email Not Sent");
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		
		driver.close();

	}

}
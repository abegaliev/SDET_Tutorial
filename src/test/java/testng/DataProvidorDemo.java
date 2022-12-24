package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtils;

public class DataProvidorDemo {
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://letskodeit.com");
		driver.findElement(By.xpath("//span[text()='Learn Now']")).click();
		// Click login button
		driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
		Thread.sleep(2000);
		// Tell the code about the location of Excel file
		ExcelUtils.openExcelFile(System.getProperty("user.dir") + "ExcelData.xlsx", "LoginTests");
	}
	
	@DataProvider(name = "loginData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtils.getTestData("Invalid_Login");
		return testData;
	}

	@Test(dataProvider="loginData")
	public void testUsingExcel(String username, String password) throws Exception {
		// Enter username
		driver.findElement(By.id("user_email")).sendKeys(username);
		// Enter password
		driver.findElement(By.id("user_password")).sendKeys(password);
		// Click Login button
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);
		
		// Find if error messages exist
		boolean result = driver.findElements(By.xpath("//form[@id='new_user']//div[3]")).size() != 0;
		Assert.assertTrue(result);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
	    //driver.quit();
	}
}
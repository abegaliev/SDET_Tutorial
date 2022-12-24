package seleniumRecap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindElementTricks {

	static WebDriver driver;
	static WebDriverWait wait;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = WebDriverUtil.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}


	@Test
	public void test() throws InterruptedException {
		driver.get("http://learn.letskodeit.com");

		WebElement practiceBtn = driver.findElement(By.xpath("//a[contains(text(), 'Practice')]"));
		System.out.println(practiceBtn.getText());
		
		practiceBtn.click();

		WebElement linkBtn = driver.findElement(By.xpath("//a[@href= 'https://courses.letskodeit.com/practice']"));
//		WebElement linkBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href= 'https://courses.letskodeit.com/practice']")));

		System.out.println(linkBtn.getText());
		linkBtn.click();
		Thread.sleep(3000);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

}

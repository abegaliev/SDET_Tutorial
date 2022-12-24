package seleniumRecap;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ScreenshotDemo {

	public static WebDriver driver;
	static WebDriverWait wait;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = WebDriverUtil.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(Duration.ofSeconds(4));
		driver.quit();

	}

	@AfterMethod
	public void takeScreenshot() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

		String filename = localDateTime.format(formatter) + ".png";
		String directory = System.getProperty("user.dir") + "//screenshots//";

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + filename));

	}

	@Test
	public void testScreenshots() {
		driver.get("https://www.facebook.com/");

		WebElement loginBtn = driver.findElement(By.cssSelector("button[name='login']"));
		loginBtn.click();


	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

}

package seleniumRecap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaitNewSyntax {

	public static void main(String args[]) {
		//		String chromePath = Config.getProperty("chromePath");

		WebDriver driver = new ChromeDriver();

		//Implicit wait

		// old implicit wait
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		// new method/ syntax in selenium 4.0
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


//		WebDriverWait wait = new WebDriverWait(driver, 4);

		// Explicit wait new syntax

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[href=login]")));

		//DesiredCapabilities -> replaced with Options
		//DesiredCapabilities capabilities = DesiredCapabalities.Chrome();

		ChromeOptions options = new ChromeOptions();
		driver.close();



	}
}

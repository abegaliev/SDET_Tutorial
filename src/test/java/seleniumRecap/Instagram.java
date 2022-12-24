package seleniumRecap;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Instagram {

	public static void main(String[] args) {

		WebDriver driver = getDriver();
		driver.get("https://instagram.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement loginBox = driver.findElement(By.cssSelector("input[name='username']"));
		wait.until(ExpectedConditions.visibilityOf(loginBox));
		loginBox.sendKeys("username");

		WebElement pwdBox = driver.findElement(By.cssSelector("input[name='password']"));
		wait.until(ExpectedConditions.visibilityOf(pwdBox));
		pwdBox.sendKeys("pwd");

		WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();

		WebElement notificBtn = driver.findElement(By.cssSelector("svg[aria-label='Notifications']"));
		wait.until(ExpectedConditions.elementToBeClickable(notificBtn));
		notificBtn.click();

		By byRequests = By.xpath("//span[text()='Follow requests']");
		wait.until(ExpectedConditions.elementToBeClickable(byRequests));
		WebElement requests = driver.findElement(byRequests);
		requests.click();


		List<WebElement> deleteReqBtns = driver.findElements(By.xpath("//span[text()='Follow requests']//parent::div/../following-sibling::div//button[text()='Delete']"));

		deleteReqBtns.forEach(s -> {
			wait.until(ExpectedConditions.elementToBeClickable(s));
			s.click();
		});

		driver.close();

	}

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/almazbek/libs/selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		return driver;
}

}
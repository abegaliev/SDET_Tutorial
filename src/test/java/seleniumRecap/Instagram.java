package seleniumRecap;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.BrowserUtil;

public class Instagram {

    @Test
    public void main() {

	WebDriver driver = BrowserUtil.getDriver();
	driver.get("https://instagram.com");

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

	List<WebElement> deleteReqBtns = driver.findElements(By.xpath(
		"//span[text()='Follow requests']//parent::div/../following-sibling::div//button[text()='Delete']"));

	deleteReqBtns.forEach(s -> {
	    wait.until(ExpectedConditions.elementToBeClickable(s));
	    s.click();
	});

	BrowserUtil.close();

    }

    public static WebDriver getDriver() {
	System.setProperty("webdriver.chrome.driver", "/Users/almazbek/libs/selenium/drivers/chromedriver");
	WebDriver driver = new ChromeDriver();
	return driver;
    }

}
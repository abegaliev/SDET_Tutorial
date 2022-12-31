package seleniumRecap;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserUtil;

public class WindowAndIframe {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

	driver = BrowserUtil.getDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void test() throws InterruptedException {
	driver.get("https://courses.letskodeit.com/practice");

	String parentHandle = driver.getWindowHandle();

	WebElement openWindowBtn = driver.findElement(By.xpath("//button[@id='openwindow']"));
	openWindowBtn.click();

	Set<String> windowHandles = driver.getWindowHandles();
	for (String window : windowHandles) {
	    if (!window.equals(parentHandle))
		driver.switchTo().window(window);
	}
	driver.findElement(By.cssSelector("input#search")).sendKeys("Hello a new Window");

	BrowserUtil.sleep(2);
	driver.close();
	driver.switchTo().window(parentHandle);
	System.out.println(driver.getCurrentUrl());

	BrowserUtil.sleep(2);

	WebElement iframe = driver.findElement(By.cssSelector("iframe#courses-iframe"));
	driver.switchTo().frame(iframe);

	BrowserUtil.sleep(2);

	WebElement searchInput = driver.findElement(By.cssSelector("input#search"));
	searchInput.sendKeys("Java selenium");

	BrowserUtil.sleep(2);

	driver.findElement(By.cssSelector("button[type='submit']")).click();

	driver.switchTo().defaultContent();

	driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys("Almazbek");
	BrowserUtil.sleep(2);

	driver.findElement(By.cssSelector("input#alertbtn")).click();
	BrowserUtil.sleep(2);

	Alert alert = driver.switchTo().alert();

	alert.dismiss();

	BrowserUtil.sleep(2);
	driver.findElement(By.id("mousehover")).click();

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

	BrowserUtil.sleep(2);
	BrowserUtil.quit();
    }
}

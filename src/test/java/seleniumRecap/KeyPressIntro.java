package seleniumRecap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserUtil;

public class KeyPressIntro {

    static WebDriver driver = BrowserUtil.getDriver();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	driver = WebDriverUtil.getDriver();
	driver.get("https://letskodeit.teachable.com/");

    }

    @Test
    public void test() throws InterruptedException {

	Thread.sleep(Duration.ofSeconds(2));
	WebElement loginBtn = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
	//		loginBtn.click();

	loginBtn.sendKeys(Keys.RETURN);

	Thread.sleep(Duration.ofSeconds(3));

	WebElement emailField = driver.findElement(By.id("email"));
	emailField.sendKeys("login@mail.com");
	Thread.sleep(Duration.ofSeconds(2));
	emailField.sendKeys(Keys.TAB);
	Thread.sleep(Duration.ofSeconds(2));
	driver.findElement(By.id("password")).sendKeys("password");
	Thread.sleep(Duration.ofSeconds(2));

	driver.findElement(By.cssSelector("input[name='commit']")).sendKeys(Keys.ENTER);

    }

    @Test
    public void test2() throws InterruptedException {
	driver.navigate().back();
	driver.get("https://courses.letskodeit.com/practice");
	Thread.sleep(Duration.ofSeconds(2));

	WebElement openTabBtn = driver.findElement(By.id("opentab"));

	// same as openTabBtn.sendKeys(Keys.cord(Keys.COMMAND,"a"));
	openTabBtn.sendKeys(Keys.COMMAND + "a");

	Thread.sleep(Duration.ofSeconds(2));
	openTabBtn.sendKeys(Keys.COMMAND + "c");

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	Thread.sleep(Duration.ofSeconds(2));
	BrowserUtil.quit();
    }

}

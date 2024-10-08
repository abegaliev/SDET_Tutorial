package seleniumRecap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserUtil;
import utilities.Extent;

public class KeyPressIntro {

    static WebDriver driver = BrowserUtil.getDriver();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	driver = WebDriverUtil.getDriver();
	driver.get("https://letskodeit.teachable.com/");
	Extent.startExtentReport();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
	Extent.passOrFailTest(result);
    }

    @Test
    public void test() throws InterruptedException {

	BrowserUtil.sleep(2);
	WebElement loginBtn = driver.findElement(By.xpath("//a[contains(text(),'Login333')]"));
	//		loginBtn.click();

	//	loginBtn.sendKeys(Keys.RETURN);

	BrowserUtil.sleep(2);

	WebElement emailField = driver.findElement(By.id("email"));
	emailField.sendKeys("login@mail.com");
	BrowserUtil.sleep(2);
	emailField.sendKeys(Keys.TAB);
	BrowserUtil.sleep(2);
	driver.findElement(By.id("password")).sendKeys("password");
	BrowserUtil.sleep(2);

	driver.findElement(By.cssSelector("input[name='commit']")).sendKeys(Keys.ENTER);
	Assert.assertTrue(false);
    }

    @Test
    public void test2() throws InterruptedException {
	driver.navigate().back();
	driver.get("https://courses.letskodeit.com/practice");
	BrowserUtil.sleep(2);

	WebElement openTabBtn = driver.findElement(By.id("opentab"));

	// same as openTabBtn.sendKeys(Keys.cord(Keys.COMMAND,"a"));
	openTabBtn.sendKeys(Keys.COMMAND + "a");

	BrowserUtil.sleep(2);
	openTabBtn.sendKeys(Keys.COMMAND + "c");
	Assert.assertTrue(true);

    }

    @Test
    public void test3() throws InterruptedException {
	driver.navigate().back();
	driver.get("https://courses.letskodeit.com/practice");
	BrowserUtil.sleep(2);

	WebElement openTabBtn = driver.findElement(By.id("opentab"));

	// same as openTabBtn.sendKeys(Keys.cord(Keys.COMMAND,"a"));
	openTabBtn.sendKeys(Keys.COMMAND + "a");

	BrowserUtil.sleep(2);
	openTabBtn.sendKeys(Keys.COMMAND + "c");
	Assert.assertTrue(true);

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	//Thread.sleep(Duration.ofSeconds(2));

	BrowserUtil.sleep(2);
	BrowserUtil.quit();
    }

}

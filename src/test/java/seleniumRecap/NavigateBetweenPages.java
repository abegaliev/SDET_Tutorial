package seleniumRecap;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserUtil;

public class NavigateBetweenPages {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	driver = BrowserUtil.getDriver();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	BrowserUtil.quit();
    }

    @Test
    public void test() throws InterruptedException {

	driver.get("http://learn.letskodeit.com");

	System.out.println("Page title :" + driver.getTitle());
	System.out.println("Current Url :" + driver.getCurrentUrl());

	assertEquals("Home | Let's Kode It", driver.getTitle());
	assertEquals("https://learn.letskodeit.com/", driver.getCurrentUrl());

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

	driver.findElement(By.linkText("Practice")).click();

	WebElement infor = driver.findElement(By.xpath("//h1/a"));
	wait.until(ExpectedConditions.visibilityOf(infor));

	String newLink = infor.getAttribute("href").toString();
	System.out.println(newLink);
	infor.click();

	driver.navigate().back();
	BrowserUtil.sleep(2);
	driver.navigate().forward();

	BrowserUtil.sleep(2);
	WebElement openTabBtn = driver.findElement(By.id("opentab"));
	wait.until(ExpectedConditions.elementToBeClickable(openTabBtn)).click();

	BrowserUtil.sleep(2);
	List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
	System.out.println("Window handles: " + windowHandles.toString());
	driver.switchTo().window(windowHandles.get(1));
	System.out.println(driver.getTitle());
	BrowserUtil.sleep(2);
	assertEquals("All Courses", driver.getTitle());

	BrowserUtil.sleep(2);
	driver.switchTo().window(windowHandles.get(0));

	BrowserUtil.sleep(2);
	Select select = new Select(driver.findElement(By.id("carselect")));
	System.out.println(select.getAllSelectedOptions().size());

	BrowserUtil.sleep(2);
	select.selectByValue("benz");
	BrowserUtil.sleep(2);
	select.selectByVisibleText("Honda");
	BrowserUtil.sleep(2);
	System.out.println("Selected options: " + select.getAllSelectedOptions().get(0).getText());

	MyDriver.waitForElementVisibility(By.id("carselect"), 5);

    }

}

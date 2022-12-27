package seleniumRecap;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserUtil;

public class MyDriver {

    static WebDriver driver = BrowserUtil.getDriver();

    public static boolean isPresent(By by) {
	List<WebElement> elements = driver.findElements(by);
	return (elements.size() > 0);
    }

    public static WebElement waitForElementVisibility(By locator, int seconds) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	return element;
    }

    public static List<WebElement> waitForElementsVisibility(By locator, int seconds) {
	List<WebElement> listElement = new ArrayList<>();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

	listElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	if (listElement.isEmpty())
	    System.out.println("Unable to locate elements by locator: " + locator.toString());

	return listElement;
    }

}

enum Locator {

    ID, NAME, ClassNAME, XPATH, CssSELECTOR;

}
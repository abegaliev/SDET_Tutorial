package seleniumRecap;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserUtil;

public class AutoCompleteDemo {

    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	driver = BrowserUtil.getDriver();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
	Thread.sleep(5000);
	BrowserUtil.quit();
    }

    @Test
    public void test() {
	String partialText = "Lon";
	String textToSelect = "London, United Kingdom";

	driver.get("https://goibibo.com");

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	WebElement inputCityBox = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Enter city or airport']/..")));
	inputCityBox.click();
	WebElement inputText = wait.until(ExpectedConditions
		.visibilityOfElementLocated(By.xpath("//span[text() ='From']/following-sibling::input[@type='text']")));

	inputText.sendKeys(partialText);

	List<WebElement> citiesList = wait.until(ExpectedConditions
		.visibilityOfAllElementsLocatedBy(By.cssSelector("ul#autoSuggest-list span.autoCompleteTitle")));

	System.out.println("Size :" + citiesList.size());

	//		Iterator<WebElement> iterator = citiesList.iterator();
	//		while (iterator.hasNext()) {
	//			WebElement element = iterator.next();
	//			if (element.getText().trim().equals(textToSelect)) {
	//				element.click();
	//				break;
	//			}
	//		}

	citiesList = citiesList.stream().filter(s -> s.getText().trim().equals(textToSelect))
		.collect(Collectors.toList());

	System.out.println(citiesList.size());
	citiesList.get(0).click();

    }

}

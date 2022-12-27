package seleniumRecap;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BrowserUtil;

public class JavaScriptDemo {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
	driver = BrowserUtil.getDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	js = (JavascriptExecutor) driver;

    }

    @AfterClass
    public void tearDownAfterClass() throws Exception {
	Thread.sleep(Duration.ofSeconds(2));
	BrowserUtil.quit();

    }

    @Test
    public void test() throws InterruptedException {
	js.executeScript("window.location= 'https://courses.letskodeit.com/practice';");

	//		WebElement signInBtn = getElement(By.xpath("//input[@id='bmwradio']"));
	WebElement signInBtn = getElement(By.id("bmwradio"));

	System.out.println("Element " + signInBtn.getText());
	signInBtn.click();
	Thread.sleep(Duration.ofSeconds(2));
	scrollToButtom();
    }

    public void scrollToButtom() {
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void refreshWindow() {
	js.executeScript("location.reload()");
    }

    /**
     * Finds and returns WebElement using JavascriptExecutor
     * 
     * @param By locator
     * @return WebElement
     */
    public WebElement getElement(By locator) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element = null;

	String locText = locator.toString();
	System.out.println(locText);
	int index = locText.indexOf(" ") + 1;
	locText = locText.substring(index);
	locText = "'" + locText + "'";

	if (locator instanceof ById) {
	    element = (WebElement) js.executeScript("return document.getElementById(" + locText + ");");

	} else if (locator instanceof ByClassName) {
	    List<WebElement> list = (List<WebElement>) js
		    .executeScript("return document.getElementsByClassName(" + locText + ");");
	    if (list.size() > 0)
		element = list.get(0);

	} else if (locator instanceof ByName) {
	    List<WebElement> list = (List<WebElement>) js
		    .executeScript("return document.getElementsByName(" + locText + ");");
	    if (list.size() > 0)
		element = list.get(0);

	} else if (locator instanceof ByCssSelector) {
	    element = (WebElement) js.executeScript("return document.querySelector(" + locText + ");");

	    //		} else if (locator instanceof ByXPath) {
	    //
	    //			String script = "return document.evaluate(" + locText + ", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;";
	    //			element = (WebElement) js.executeScript(script);
	}

	if (element == null)
	    throw new NoSuchElementException(locator.toString());

	return element;
    }

}

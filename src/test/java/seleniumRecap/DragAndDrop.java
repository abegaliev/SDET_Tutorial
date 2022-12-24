package seleniumRecap;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = WebDriverUtil.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://jqueryui.com");
		Actions action = new Actions(driver);

		// Drag And Drop
		Thread.sleep(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//aside[@class='widget']//a[text()='Droppable']")).click();

		WebElement demoFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(demoFrame);
		Thread.sleep(Duration.ofSeconds(2));

		WebElement fromElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement toElement = driver.findElement(By.xpath("//div[@id='droppable']"));

//		action.dragAndDrop(fromElement, toElement).build().perform();
		action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		Thread.sleep(Duration.ofSeconds(2));

		// Resizable
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//aside[@class='widget']//a[text()='Resizable']")).click();
		Thread.sleep(Duration.ofSeconds(2));
		WebElement frame2 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame2);

		WebElement sizePointer = driver.findElement(By.cssSelector("div[style='z-index: 90;'][class*='ui-icon']"));
		action.clickAndHold(sizePointer).moveByOffset(90, 100).build().perform();
		Thread.sleep(Duration.ofSeconds(2));

		// Selectable
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//aside[@class='widget']//a[text()='Selectable']")).click();
		Thread.sleep(Duration.ofSeconds(2));
		WebElement frame3 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame3);

		Thread.sleep(Duration.ofSeconds(2));
		WebElement firstElement = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 1']"));
		WebElement lastElement = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 7']"));
		action.clickAndHold(firstElement).moveToElement(lastElement).build().perform();
		Thread.sleep(Duration.ofSeconds(2));

		// Sortable
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//aside[@class='widget']//a[text()='Sortable']")).click();
		Thread.sleep(Duration.ofSeconds(2));
		WebElement frame4 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame4);

		Thread.sleep(Duration.ofSeconds(2));
		List<WebElement> sortables = driver.findElements(By.xpath("//ul[@id='sortable']/li"));

//		Iterator<WebElement> iterator = sortables.iterator();
//		while (iterator.hasNext()) {
//			action.clickAndHold(iterator.next()).moveToElement(iterator.next()).build().perform();
//			Thread.sleep(Duration.ofSeconds(2));
//		}

		for (int i = 0; i < sortables.size() - 1; i++) {
			action.clickAndHold(sortables.get(i)).moveToElement(sortables.get(i + 1)).build().perform();
		}

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		Thread.sleep(Duration.ofSeconds(3));
		driver.quit();

	}
}

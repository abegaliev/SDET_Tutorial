package seleniumRecap;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	static WebDriver driver;

	public static void main(String[] args) {
		String url = "http://learn.letskodeit.com";




		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();

		WebElement loginBox = driver.findElement(By.xpath("//a[@href='/sign_in']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		driver.findElement(By.linkText("Practice")).click();

		WebElement infor = driver.findElement(By.xpath("//h1/a"));
		wait.until(ExpectedConditions.visibilityOf(infor));

		String newLink = infor.getAttribute("href").toString();
		System.out.println(newLink);
		infor.click();

		List<WebElement> radioOptn = driver
				.findElements(By.xpath("//div[@id='radio-btn-example']//input"));
		
		radioOptn.forEach(d -> System.out.println(d.getDomAttribute("value")));

		radioOptn.forEach(s -> {
			s.click();
			try {
				Thread.sleep(Duration.ofSeconds(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});


//		wait.until(ExpectedConditions.elementToBeClickable(loginBox));
//		loginBox.click();
//
//		WebElement emailBox = driver.findElement(By.cssSelector("#email"));
//		wait.until(ExpectedConditions.visibilityOf(emailBox));
//		emailBox.sendKeys("letskodeit@gmail.com");
//
//
//		WebElement passwordBox = driver.findElement(By.cssSelector("#password"));
//		wait.until(ExpectedConditions.visibilityOf(passwordBox));
//		passwordBox.sendKeys("Password");
//
//		driver.findElement(By.xpath("//input[@name='commit']")).click();

		driver.findElement(By.id("carselect")).click();

		WebElement selectOpt = driver.findElement(By.id("carselect"));
		Select select = new Select(selectOpt);

		select.getOptions().forEach(s -> System.out.println(s.getText()));
		select.getOptions().forEach(s -> s.click());

		driver.close();

	}

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/almazbek/libs/selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static boolean isPresent(By by) {
		driver = getDriver();
		List<WebElement> elements = driver.findElements(by);
		return elements.size() > 0;
	}



}

package formation_CAIt.selenium_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeOption {

	protected static WebDriver driver;

	@BeforeTest
	public static void Chrome_options() {

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();// initialisation de l'instance chromeoptions
		options.addArguments("..disable-extensions");// désactiver les extensions
		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);

		// driver.manage().window().maximize();
	}

	@Test
	public static void first_test() throws InterruptedException {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(5000);

		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("btnAdd")).click();

		driver.findElement(By.name("firstName")).sendKeys("Celine");
		driver.findElement(By.name("middleName")).sendKeys("beguin");
		driver.findElement(By.name("lastName")).sendKeys("beguin");

		// driver.quit();

	}
}

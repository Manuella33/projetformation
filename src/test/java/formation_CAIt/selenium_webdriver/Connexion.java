package formation_CAIt.selenium_webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Connexion {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		// ajout du chemin du driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testConnexion() throws Exception {
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/auth/login");
		driver.findElement(By.id("divLogo")).click();
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).click();
		driver.findElement(By.name("txtPassword")).sendKeys("Manel3388@");
		driver.findElement(By.id("btnLogin")).click();
	}

}

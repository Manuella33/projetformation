package formation_CAIt.selenium_webdriver.jobtitle;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ModifierJobTitle {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		// ajout du chemin du driver
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void testConnexion() throws Exception {
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/auth/login");
		driver.findElement(By.id("divLogo")).click();
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).click();
		driver.findElement(By.name("txtPassword")).sendKeys("Manel3388@");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test
	public void testModifierTitle() throws Exception {
		testConnexion();
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.linkText("consultanttest1")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("jobTitle_jobDescription")).click();
		driver.findElement(By.id("jobTitle_jobDescription")).clear();
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("consultanttest1 modifier");
		driver.findElement(By.id("btnSave")).click();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}

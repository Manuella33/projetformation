package formation_CAIt.selenium_webdriver;

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

public class CreerPayGrade {
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
	public void testAjouterPaygrade() throws Exception {
		testConnexion();
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewPayGrades")).click();
		int i = 1;
		do {
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("payGrade_name")).clear();
			driver.findElement(By.id("payGrade_name")).sendKeys("Pay grade " + i);
			driver.findElement(By.id("btnSave")).click();
			driver.findElement(By.id("btnAddCurrency")).click();
			driver.findElement(By.id("payGradeCurrency_currencyName")).clear();
			driver.findElement(By.id("payGradeCurrency_currencyName")).sendKeys("eu");
			driver.findElement(By.xpath("//div[4]/ul/li")).click();
			driver.findElement(By.id("payGradeCurrency_minSalary")).clear();
			driver.findElement(By.id("payGradeCurrency_minSalary")).sendKeys("5000");
			driver.findElement(By.id("payGradeCurrency_maxSalary")).clear();
			driver.findElement(By.id("payGradeCurrency_maxSalary")).sendKeys("7000");
			driver.findElement(By.id("btnSaveCurrency")).click();
			driver.findElement(By.id("btnCancel")).click();
			i = i + 1;
		} while (i <= 4);
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

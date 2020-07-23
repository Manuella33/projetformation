package formation_CAIt.selenium_webdriver.jobtitle;

//package com.example.tests;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreerJobTitle {
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
	public void testJobTitle() throws Exception {
		// TODO Avant de lancer le test, remettre à zero l'increment de l'id dans la table avec la requete suivante
		// ALTER TABLE ohrm_job_title AUTO_INCREMENT = 1
				
		testConnexion();
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");

		// ERROR: Caught exception [ERROR: Unsupported command [loadVars | donneesJT.csv
		// | ]]
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		
		for (int i = 1; i <= 4; i++) {
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("jobTitle_jobTitle")).click();
			driver.findElement(By.id("jobTitle_jobTitle")).clear();
			driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("consultanttest" + i);
			driver.findElement(By.id("jobTitle_jobDescription")).click();
			driver.findElement(By.id("jobTitle_jobDescription")).clear();
			driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("consultanttest" + i);
			driver.findElement(By.id("jobTitle_note")).click();
			driver.findElement(By.id("jobTitle_note")).clear();
			driver.findElement(By.id("jobTitle_note")).sendKeys("consultant" + i);
			// ERROR: Caught exception [ERROR: Unsupported command [endLoadVars | | ]]
			driver.findElement(By.id("btnSave")).click();
		}
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

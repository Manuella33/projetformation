package formation_CAIt.selenium_webdriver.jobtitle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import formation_CAIt.selenium_webdriver.Connexion;

public class CreerJobTitle {
	private static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public static void setUp() throws Exception {
		driver = Connexion.getDriver();
	}

	@Test
	public void testJobTitle() throws Exception {
		
		// ALTER TABLE ohrm_job_title AUTO_INCREMENT = 1
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
			driver.findElement(By.id("btnSave")).click();
		}
	}
}

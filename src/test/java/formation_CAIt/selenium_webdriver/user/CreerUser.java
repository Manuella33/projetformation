package formation_CAIt.selenium_webdriver.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import formation_CAIt.selenium_webdriver.Connexion;

public class CreerUser {
	private static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public static void setUp() throws Exception {
		driver = Connexion.getDriver();
	}

	@Test
	public void testAdduserAdmin() throws Exception {
		// ALTER TABLE ohrm_user AUTO_INCREMENT = 2
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		for (int i = 1; i <= 4; i++) {

			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("systemUser_userType")).click();
			new Select(driver.findElement(By.id("systemUser_userType"))).selectByVisibleText("Admin");
			driver.findElement(By.id("systemUser_userType")).click();
			driver.findElement(By.id("systemUser_employeeName_empName")).click();
			driver.findElement(By.id("systemUser_employeeName_empName")).clear();
			driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("employe " + i);
			driver.findElement(By.xpath("//div[4]/ul/li")).click();
			driver.findElement(By.id("systemUser_userName")).click();
			driver.findElement(By.id("systemUser_userName")).clear();
			driver.findElement(By.id("systemUser_userName")).sendKeys("admin_username " + i);
			driver.findElement(By.id("systemUser_password")).clear();
			driver.findElement(By.id("systemUser_password")).sendKeys("Manel3388!");
			driver.findElement(By.id("systemUser_confirmPassword")).clear();
			driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Manel3388!");
			Thread.sleep(3000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(3000);
		}

	}
	
	@Test
	public void testAdduserEss() throws Exception {
		
		// ALTER TABLE ohrm_user AUTO_INCREMENT = 2
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();

		for (int i = 5; i <= 6; i++) {
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("systemUser_userType")).click();
			new Select(driver.findElement(By.id("systemUser_userType"))).selectByVisibleText("ESS");
			driver.findElement(By.id("systemUser_userType")).click();
			driver.findElement(By.id("systemUser_employeeName_empName")).click();
			driver.findElement(By.id("systemUser_employeeName_empName")).clear();
			driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("employe " + i);
			driver.findElement(By.xpath("//div[4]/ul/li")).click();
			driver.findElement(By.id("systemUser_userName")).click();
			driver.findElement(By.id("systemUser_userName")).clear();
			driver.findElement(By.id("systemUser_userName")).sendKeys("ess_username " + i);
			driver.findElement(By.id("systemUser_password")).clear();
			driver.findElement(By.id("systemUser_password")).sendKeys("Manel3388!");
			driver.findElement(By.id("systemUser_confirmPassword")).clear();
			driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Manel3388!");
			Thread.sleep(3000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(3000);

		}

	}
}

package formation_CAIt.selenium_webdriver.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import formation_CAIt.selenium_webdriver.Connexion;

public class ModifierUser {
	private static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public static void setUp() throws Exception {
		driver = Connexion.getDriver();
	}

	@Test
	public void testModifierUser() throws Exception {
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();

		driver.findElement(By.linkText("admin_username 1")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).click();
		driver.findElement(By.id("systemUser_userName")).clear();
		driver.findElement(By.id("systemUser_userName")).sendKeys("admin_username 1 modif");
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);

	}
}

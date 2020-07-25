package formation_CAIt.selenium_webdriver.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import formation_CAIt.selenium_webdriver.Connexion;

public class SupprimerUser {
	private static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public static void setUp() throws Exception {
		driver = Connexion.getDriver();
	}

	@Test
	public void testSupprimerUser() throws Exception {
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();

		driver.findElement(By.id("ohrmList_chkSelectRecord_6")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();

		driver.findElement(By.id("ohrmList_chkSelectRecord_7")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();

		for (int i = 3; i <= 5; i++) {
			driver.findElement(By.id("ohrmList_chkSelectRecord_" + i)).click();
		}
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
	}
}
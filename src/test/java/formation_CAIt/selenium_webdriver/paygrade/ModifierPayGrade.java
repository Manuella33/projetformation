package formation_CAIt.selenium_webdriver.paygrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import formation_CAIt.selenium_webdriver.Connexion;

public class ModifierPayGrade {
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = Connexion.getDriver();
	}

	@Test
	public void testModifierPayGrade() throws Exception {
		driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewPayGrades")).click();
		driver.findElement(By.linkText("Pay grade 1")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("payGrade_name")).click();
		driver.findElement(By.id("payGrade_name")).clear();
		driver.findElement(By.id("payGrade_name")).sendKeys("Pay grade modif 1");
		driver.findElement(By.xpath("//form[@id='frmPayGrade']/fieldset/p")).click();
		driver.findElement(By.id("btnSave")).click();

	}
}

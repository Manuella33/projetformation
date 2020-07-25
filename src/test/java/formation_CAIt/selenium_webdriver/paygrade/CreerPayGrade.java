package formation_CAIt.selenium_webdriver.paygrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import formation_CAIt.selenium_webdriver.Connexion;

public class CreerPayGrade {
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = Connexion.getDriver();
	}

	@Test
	public void testAjouterPaygrade() throws Exception {
		
		// ALTER TABLE ohrm_pay_grade AUTO_INCREMENT = 1
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
}

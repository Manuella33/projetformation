package formation_CAIt.selenium_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import formation_CAIt.selenium_webdriver.Connexion;

public class Deconnexionclose {
	private static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public static void setUp() throws Exception {
		driver = Connexion.getDriver();
	}
 

  @Test
  public void testDOnnexionclose() throws Exception {
    driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/dashboard");
    driver.findElement(By.id("welcome")).click();
    driver.findElement(By.linkText("Logout")).click();
    Thread.sleep(3000);
    driver.close();
  }
}
  

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GeckoWebDriver {

	

		@Test
		public static void startGeckoDriver() {
			
			System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
			/* ceci est un commentaire     */
			///* ceci est un commentaire     */
			WebDriver driver = new FirefoxDriver(); //initialisation de l'instance du driver
			driver.get("https://www.google.fr");  //demarrage du navigateur
			driver.quit(); //Fermeture du navigateur
			}

}

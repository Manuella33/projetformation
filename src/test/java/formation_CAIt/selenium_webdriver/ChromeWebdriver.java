package formation_CAIt.selenium_webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeWebdriver {

	@Test
	public static void startChromeDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		/* ceci est un commentaire */
		/// * ceci est un commentaire */
		WebDriver driver = new ChromeDriver(); // initialisation de l'instance du driver
		driver.get("https://www.google.fr"); // demarrage du navigateur
		driver.quit(); // Fermeture du navigateur

	}

}

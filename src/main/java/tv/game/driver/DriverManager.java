package tv.game.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static WebDriver driver;
	private static String browser = System.getProperty("sys.application.browser");
	private static String mainWindow;

	public static void initializaeDriver() {
		if (browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashwat\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
			mainWindow = driver.getWindowHandle();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getMainWindow() {
		return mainWindow;
	}
}

package tv.game.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import tv.game.driver.DriverManager;
import tv.game.pages.GamePage;

public class Utils {

	public static GamePage openLinkInNewTab(WebElement element) {
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		element.findElement(By.tagName("a")).sendKeys(selectLinkOpeninNewTab);
		switchToLatestWindow();
		return new GamePage();
	}

	public static void switchToLatestWindow() {
		String latestWindow = DriverManager.getDriver().getWindowHandles().stream().reduce((first, second) -> second)
				.get();
		DriverManager.getDriver().switchTo().window(latestWindow);
	}

	public static void switchToMainWindow() {
		DriverManager.getDriver().close();
		DriverManager.getDriver().switchTo().window(DriverManager.getMainWindow());
	}

	public static String getLink(WebElement element) {
		return element.findElement(By.tagName("a")).getAttribute("href");
	}

	public static String getName(WebElement element) {
		return element.findElement(By.className("game-name")).getText();
	}

	public static int getStatus(String link) throws MalformedURLException, IOException {
		HttpURLConnection connection = (HttpURLConnection) (new URL(link).openConnection());
		connection.setRequestMethod("GET");
		connection.connect();
		return connection.getResponseCode();
	}
}

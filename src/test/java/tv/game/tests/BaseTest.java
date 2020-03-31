package tv.game.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import tv.game.driver.DriverManager;

public class BaseTest {

	@BeforeMethod()
	public void beforeMethod() {
		DriverManager.initializaeDriver();
	}

	@AfterMethod()
	public void afterMethod() {
		DriverManager.getDriver().quit();
	}

}

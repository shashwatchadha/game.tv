package tv.game.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tv.game.driver.DriverManager;

public class HomePage {
	
	@FindBy(css=".game-list-wrapper li")
	List<WebElement> gameGrid;
	
	
	
	
	
	
	private static String url = System.getProperty("sys.application.url");
	
	public HomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public static HomePage goTO() {
		DriverManager.getDriver().get(url);
		return new HomePage();
	}
	
	public List<WebElement> getGameElements()
	{
		return gameGrid;
	}

}

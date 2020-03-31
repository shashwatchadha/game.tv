package tv.game.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tv.game.driver.DriverManager;

public class GamePage {

	
	
	@FindBy(className = "count-tournaments")
	WebElement tournamentClass;
	
	public GamePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public String getTournamentCount() {
		return tournamentClass.getText();
	}
}

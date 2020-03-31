package tv.game.utils;

public class GameDetail {
	
	
	String gameName;
	String gameLink;
	int statusCode;
	String count;
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameLink() {
		return gameLink;
	}
	public void setGameLink(String gameLink) {
		this.gameLink = gameLink;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	public String toString()
	{
		return gameName+"     "+gameLink+"  "+statusCode+"   "+count;
		
	}

}

package tv.game.tests;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import tv.game.pages.HomePage;
import tv.game.utils.GameDetail;
import tv.game.utils.Utils;

public class Test1 extends BaseTest {

	List<GameDetail> gameDetailList;
	GameDetail gameDetail;
	Gson gson = new Gson();

	@Test
	public void test1() throws IOException {

		List<WebElement> elements = HomePage.goTO().getGameElements();
		gameDetailList = new ArrayList<GameDetail>();

		for (WebElement element : elements) {
			String link = Utils.getLink(element);
			String gameName = Utils.getName(element);
			Connection connection = Jsoup.connect(link);
			int status = connection.execute().statusCode();
			String count = connection.get().getElementsByClass("count-tournaments").text();
			gameDetail = new GameDetail();
			gameDetail.setGameName(gameName);
			gameDetail.setGameLink(link);
			gameDetail.setStatusCode(status);
			gameDetail.setCount(count);
			gameDetailList.add(gameDetail);
		}
		gson.toJson(gameDetailList, new FileWriter("testResult1.json"));
		gameDetailList.forEach(a -> System.out.println(a));
	}

	@Test
	public void test2() throws IOException {

		List<WebElement> elements = HomePage.goTO().getGameElements();
		gameDetailList = new ArrayList<GameDetail>();

		for (WebElement element : elements) {
			String link = Utils.getLink(element);
			String gameName = Utils.getName(element);
			int status = Utils.getStatus(link);
			String count = Utils.openLinkInNewTab(element).getTournamentCount();
			Utils.switchToMainWindow();
			gameDetail = new GameDetail();
			gameDetail.setGameName(gameName);
			gameDetail.setGameLink(link);
			gameDetail.setStatusCode(status);
			gameDetail.setCount(count);
			gameDetailList.add(gameDetail);
		}
		gson.toJson(gameDetailList, new FileWriter("testResult2.json"));
		gameDetailList.forEach(a -> System.out.println(a));

	}
}

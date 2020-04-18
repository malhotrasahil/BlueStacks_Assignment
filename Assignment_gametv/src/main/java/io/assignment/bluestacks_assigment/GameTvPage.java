
package io.assignment.bluestacks_assigment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GameTvPage {
	private WebDriver driver;
	private GameDetail gameDetail;
	private GameDetailPage gameDetailPage;

	@FindAll({ @FindBy(xpath = "(//li[@class='games-item']//figcaption[@class='game-name'])") })
	private List<WebElement> gamesItem;

	@FindAll({ @FindBy(xpath = "(//li[@class='games-item']//a)") })
	private List<WebElement> gamesItemLink;

	public GameTvPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getAllGamesDetails() throws IOException {
		gameDetail=new GameDetail();
		gameDetailPage=new GameDetailPage(this.driver);
		for (int gameNum=0;gameNum<gamesItem.size();gameNum++) {
			gameDetail.setSerialNumber(gameNum+1);
			gameDetail.setGameName(gamesItem.get(gameNum).getText());
			gameDetail.setPageUrl(gamesItemLink.get(gameNum).getAttribute("href"));
			gameDetail.setPageStatusCode(getGamePageStatusCode(gamesItemLink.get(gameNum).getAttribute("href")));
			gamesItemLink.get(gameNum).click();
			gameDetail.setTournamentCount(gameDetailPage.tournamentCount());
			driver.navigate().back();
			System.out.println(gameDetail.getSerialNumber()+"\t"+gameDetail.getGameName()+"\t"+gameDetail.getPageUrl()+"\t"+gameDetail.getPageStatusCode()+"\t"+gameDetail.getTournamentCount());
		}

	}

	private int getGamePageStatusCode(String url) throws IOException {
		URL gameUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)gameUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		return connection.getResponseCode();
	}

}

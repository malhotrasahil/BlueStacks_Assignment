
package io.assignment.bluestacks_assigment;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GameDetailPage {
	
	private WebDriver driver;

	@FindBy(xpath = "//span[@class='count-tournaments']")
	private WebElement tournamentCount;

	public GameDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String tournamentCount() {
		return tournamentCount.getText();
		
	}

}

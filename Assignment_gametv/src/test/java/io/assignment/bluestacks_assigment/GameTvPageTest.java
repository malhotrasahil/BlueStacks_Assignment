package io.assignment.bluestacks_assigment;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class GameTvPageTest {
	private WebDriver driver;
	private GameTvPage gameTvPage;
	private final static String BASEURL="https://www.game.tv";

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		
		PrintStream fileOut = new PrintStream(System.getProperty("user.dir")+"/results/Output_Problem_1.txt");
        System.setOut(fileOut);
        
        System.out.println("#"+"\t"+"Game_Name"+"\t"+"Page_URL"+"\t"+"Page_Status"+"\t"+"Tournament_Count");
        
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  
        driver.manage().window().maximize();
        driver.get(BASEURL);
	}
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test
	public void getAllGamesDetails() throws IOException {
		gameTvPage=new GameTvPage(driver);
		gameTvPage.getAllGamesDetails();
	}
}

package uk.co.jamesmcguigan.rockpaperscissors.AcceptanceTests.Stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class PaperRockScissorsSteps {

	private WebDriver webDriver;

	@Before
	public void initSelenium() throws Exception {
		webDriver = new FirefoxDriver();
	}

	@Given("^a new game of rock, paper, scissors$")
	public void a_new_game_of_rock_paper_scissors() {
		webDriver.get("http://localhost:9002/");
	}

	@Given("^I am Player (\\d+)$")
	public void I_am_Player(int arg1) {
		webDriver.findElement(By.id("player1-human")).click();
		Assert.assertTrue(webDriver.findElement(By.id("player1Gesture"))
				.isDisplayed());
	}

	@Given("^Player (\\d+) is the Computer$")
	public void Player_is_the_Computer(int arg1) {
		if (arg1 == 1) {
			webDriver.findElement(By.id("player1-computer")).click();
			Assert.assertFalse(webDriver.findElement(By.id("player1Gesture"))
					.isDisplayed());
		}
	}

	@Given("^a previous game ended with a successful outcome$")
	public void a_previous_game_ended_with_a_successful_outcome() {
		I_play_a_game();
		Assert.assertTrue(webDriver.findElement(By.id("winning-condition"))
				.isDisplayed());
		Assert.assertTrue(webDriver.findElement(By.id("winning-player"))
				.isDisplayed());
	}

	@When("^I play a different game$")
	public void I_play_a_different_game() {
		Player_is_the_Computer(1);
		I_play_a_game();
	}

	@When("^I play a game$")
	public void I_play_a_game() {
		webDriver.findElement(By.id("play-game")).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("winning-player")));
	}

	@Then("^an outcome from the game will be reached.$")
	public void an_outcome_from_the_game_will_be_reached() {
		Assert.assertTrue(webDriver.findElement(By.id("winning-player"))
				.isDisplayed());
		Assert.assertTrue(webDriver.findElement(By.id("winning-condition"))
				.isDisplayed());
		Assert.assertFalse(webDriver.findElement(By.id("error-message"))
				.isDisplayed());
	}

	@Then("^a different outcome from the game will be reached.$")
	public void a_different_outcome_from_the_game_will_be_reached() {

		String game1 = webDriver.findElement(By.id("winning-condition"))
				.getText();
		I_play_a_game();
		String game2 = webDriver.findElement(By.id("winning-condition"))
				.getText();
		I_play_a_game();
		String game3 = webDriver.findElement(By.id("winning-condition"))
				.getText();
		Assert.assertFalse(game1.equals(game2) && game2.equals(game3));
	}

	@After
	public void destroySelenium() {
		webDriver.quit();
	}
}

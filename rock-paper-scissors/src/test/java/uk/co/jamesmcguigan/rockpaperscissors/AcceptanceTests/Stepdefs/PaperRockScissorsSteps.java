package uk.co.jamesmcguigan.rockpaperscissors.AcceptanceTests.Stepdefs;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class PaperRockScissorsSteps implements SauceOnDemandSessionIdProvider {

	public static final String HTTP_LOCALHOST = "http://localhost:9002/";
	public static final String PLAYER_1_GESTURE = "player1Gesture";
	public static final String PLAYER1_HUMAN = "player1-human";
	public static final String PLAYER1_COMPUTER = "player1-computer";
	public static final String PLAYER1_GESTURE = "player1Gesture";
	public static final String WINNING_CONDITION = "winning-condition";
	public static final String WINNING_PLAYER = "winning-player";
	public static final String PLAY_GAME = "play-game";
	public static final String WINNING_PLAYER1 = "winning-player";
	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USER_NAME, KEY);

	@Rule
	public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);

	private static final String TRAVIS = "TRAVIS";
	private static final String USER_NAME = "modernmaster";
	private static final String KEY = "51ad2d68-61b9-4b0d-aac3-198713991a44";
	private static final String URL = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", USER_NAME, KEY);

	private WebDriver webDriver;
    private SessionId sessionId;

	@Before
	public void initSelenium(Scenario scenario) throws Throwable {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();

		desiredCapabilities.setCapability(CapabilityType.PLATFORM, "Windows XP");
		desiredCapabilities.setCapability(CapabilityType.VERSION, "43.0");
		desiredCapabilities.setCapability("build", System.getenv("TRAVIS_BUILD_NUMBER"));
		desiredCapabilities.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
		desiredCapabilities.setCapability("name", "Rock Paper Scissors Test:"+ scenario.getName());
		this.webDriver = new RemoteWebDriver(new URL(URL), desiredCapabilities);
		this.sessionId = ((RemoteWebDriver) webDriver).getSessionId();
	}

	@Given("^a new game of rock, paper, scissors$")
	public void a_new_game_of_rock_paper_scissors() {
		webDriver.get(HTTP_LOCALHOST);
	}

	@Given("^I am Player (\\d+)$")
	public void I_am_Player(int arg1) {
		webDriver.findElement(By.id(PLAYER1_HUMAN)).click();
		Assert.assertTrue(webDriver.findElement(By.id(PLAYER_1_GESTURE))
				.isDisplayed());
    }

	@Given("^Player (\\d+) is the Computer$")
	public void Player_is_the_Computer(int arg1) {
		if (arg1 == 1) {
			webDriver.findElement(By.id(PLAYER1_COMPUTER)).click();
			Assert.assertFalse(webDriver.findElement(By.id(PLAYER1_GESTURE))
					.isDisplayed());
		}
	}

	@Given("^a previous game ended with a successful outcome$")
	public void a_previous_game_ended_with_a_successful_outcome() {
		I_play_a_game();
		Assert.assertTrue(webDriver.findElement(By.id(WINNING_CONDITION))
				.isDisplayed());
		Assert.assertTrue(webDriver.findElement(By.id(WINNING_PLAYER))
				.isDisplayed());
	}

	@When("^I play a different game$")
	public void I_play_a_different_game() {
		Player_is_the_Computer(1);
		I_play_a_game();
	}

	@When("^I play a game$")
	public void I_play_a_game() {
		webDriver.findElement(By.id(PLAY_GAME)).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id(WINNING_PLAYER1)));
	}

	@Then("^an outcome from the game will be reached.$")
	public void an_outcome_from_the_game_will_be_reached() {
		Assert.assertTrue(webDriver.findElement(By.id(WINNING_PLAYER))
				.isDisplayed());
		Assert.assertTrue(webDriver.findElement(By.id(WINNING_CONDITION))
				.isDisplayed());
		Assert.assertFalse(webDriver.findElement(By.id("error-message"))
				.isDisplayed());
	}

	@Then("^a different outcome from the game will be reached.$")
	public void a_different_outcome_from_the_game_will_be_reached() {

		String game1 = webDriver.findElement(By.id(WINNING_CONDITION))
				.getText();
		I_play_a_game();
		String game2 = webDriver.findElement(By.id(WINNING_CONDITION))
				.getText();
		I_play_a_game();
		String game3 = webDriver.findElement(By.id(WINNING_CONDITION))
				.getText();
		Assert.assertFalse(game1.equals(game2) && game2.equals(game3));
	}

    @After
	public void destroySelenium(Scenario scenario) {
        ((JavascriptExecutor)webDriver).executeScript("sauce:job-result=" + (scenario.isFailed() ? "failed" : "passed"));
		webDriver.quit();
	}

    public String getSessionId() {
        return sessionId.toString();
    }
}

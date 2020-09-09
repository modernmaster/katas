package uk.co.jamesmcguigan.rockpaperscissors.acceptancetests.stepdefs;

import java.net.URL;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class PaperRockScissorsSteps implements SauceOnDemandSessionIdProvider {

    private static final String HTTP_LOCALHOST = "http://localhost:9002/rock-paper-scissors/";
    private static final String PLAYER_1_GESTURE = "player1Gesture";
    private static final String PLAYER1_HUMAN = "player1-human";
    private static final String PLAYER1_COMPUTER = "player1-computer";
    private static final String PLAYER1_GESTURE = "player1Gesture";
    private static final String WINNING_CONDITION = "winning-condition";
    private static final String WINNING_PLAYER = "winning-player";
    private static final String PLAY_GAME = "play-game";
    private static final String WINNING_PLAYER1 = "winning-player";
    private static final String USER_NAME = "modernmaster";
    private static final String KEY = "51ad2d68-61b9-4b0d-aac3-198713991a44";
    private static final String URL = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", USER_NAME, KEY);
    private final SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(USER_NAME, KEY);
    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);
    private WebDriver webDriver;
    private SessionId sessionId;

    @Before
    public void initSelenium(Scenario scenario) throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
        capabilities.setCapability(CapabilityType.VERSION, "59.0");
        capabilities.setCapability("build", System.getenv("TRAVIS_BUILD_NUMBER"));
        capabilities.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
        capabilities.setCapability("name", "Rock Paper Scissors Test:" + scenario.getName());
        this.webDriver = new RemoteWebDriver(new URL(URL), capabilities);
        this.sessionId = ((RemoteWebDriver) webDriver).getSessionId();
    }

    @Given("^a new game of rock, paper, scissors$")
    public void aNewGameOfRockPaperScissors() {
        webDriver.get(HTTP_LOCALHOST);
    }

    @Given("^I am Player (\\d+)$")
    public void iAmPlayer(int arg1) {
        webDriver.findElement(By.id(PLAYER1_HUMAN)).click();
        Assert.assertTrue(webDriver.findElement(By.id(PLAYER_1_GESTURE))
                .isDisplayed());
    }

    @Given("^Player (\\d+) is the Computer$")
    public void playerIsTheComputer(int arg1) {
        if (arg1 == 1) {
            webDriver.findElement(By.id(PLAYER1_COMPUTER)).click();
            Assert.assertFalse(webDriver.findElement(By.id(PLAYER1_GESTURE))
                    .isDisplayed());
        }
    }

    @Given("^a previous game ended with a successful outcome$")
    public void aPreviousGameEndedWithASuccessfulOutcome() {
        iPlayAGame();
        Assert.assertTrue(webDriver.findElement(By.id(WINNING_CONDITION))
                .isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.id(WINNING_PLAYER))
                .isDisplayed());
    }

    @When("^I play a different game$")
    public void iPlayADifferentGame() {
        playerIsTheComputer(1);
        iPlayAGame();
    }

    @When("^I play a game$")
    public void iPlayAGame() {
        webDriver.findElement(By.id(PLAY_GAME)).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .id(WINNING_PLAYER1)));
    }

    @Then("^an outcome from the game will be reached.$")
    public void anOutcomeFromTheGameWillBeReached() {
        Assert.assertTrue(webDriver.findElement(By.id(WINNING_PLAYER))
                .isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.id(WINNING_CONDITION))
                .isDisplayed());
        Assert.assertFalse(webDriver.findElement(By.id("error-message"))
                .isDisplayed());
    }

    @Then("^a different outcome from the game will be reached.$")
    public void aDifferentOutcomeFromTheGameWillBeReached() {

        String game1 = webDriver.findElement(By.id(WINNING_CONDITION))
                .getText();
        iPlayAGame();
        String game2 = webDriver.findElement(By.id(WINNING_CONDITION))
                .getText();
        iPlayAGame();
        String game3 = webDriver.findElement(By.id(WINNING_CONDITION))
                .getText();
        Assert.assertFalse(game1.equals(game2) && game2.equals(game3));
    }

    @After
    public void destroySelenium(Scenario scenario) {
        ((JavascriptExecutor) webDriver).executeScript("sauce:job-result=" + (scenario.isFailed() ? "failed" : "passed"));
        webDriver.quit();
    }

    public String getSessionId() {
        return sessionId.toString();
    }
}

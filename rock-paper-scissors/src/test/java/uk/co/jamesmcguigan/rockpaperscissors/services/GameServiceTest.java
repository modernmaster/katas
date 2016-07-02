package uk.co.jamesmcguigan.rockpaperscissors.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import uk.co.jamesmcguigan.rockpaperscissors.builders.GameBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.builders.GestureBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.builders.PlayerBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.models.Game;

public class GameServiceTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculateASuccessfulResultOfGame()
	{
		//Given
		GestureBuilder gestureBuilder = new GestureBuilder();
		gestureBuilder.createGestureCollection();
		PlayerBuilder player1Builder = new PlayerBuilder();
		player1Builder.setIsHuman(true);		
		player1Builder.setGesture(gestureBuilder.getGestures().get(0));
		player1Builder.createPlayer();
		PlayerBuilder player2Builder = new PlayerBuilder();
		player2Builder.setIsHuman(true);
		player2Builder.setGesture(gestureBuilder.getGestures().get(1));
		player2Builder.createPlayer();
		GameBuilder gameBuilder = new GameBuilder();
		gameBuilder.setPlayer1(player1Builder.getPlayer());
		gameBuilder.setPlayer2(player2Builder.getPlayer());
		gameBuilder.createGame();
		Game newGame = gameBuilder.getGame();
		
		GameService rockPaperScissorsService = new GameService();
		//When
		Game afterGame = rockPaperScissorsService.calculateResult(newGame);
		//Then		
		String calculatedResult = afterGame.getResult();
		Assert.assertNotNull(calculatedResult);
		Assert.assertEquals("Paper wraps Rock", calculatedResult);		
	}
	
	@Test
	public void testCalculateADrawnfGame()
	{
		//Given
		GestureBuilder gestureBuilder = new GestureBuilder();
		gestureBuilder.createGestureCollection();
		PlayerBuilder player1Builder = new PlayerBuilder();
		player1Builder.setIsHuman(true);		
		player1Builder.setGesture(gestureBuilder.getGestures().get(0));
		player1Builder.createPlayer();
		PlayerBuilder player2Builder = new PlayerBuilder();
		player2Builder.setIsHuman(true);
		player2Builder.setGesture(gestureBuilder.getGestures().get(0));
		player2Builder.createPlayer();
		GameBuilder gameBuilder = new GameBuilder();
		gameBuilder.setPlayer1(player1Builder.getPlayer());
		gameBuilder.setPlayer2(player2Builder.getPlayer());
		gameBuilder.createGame();
		Game newGame = gameBuilder.getGame();		
		
		GameService rockPaperScissorsService = new GameService();
		//When
		Game afterGame = rockPaperScissorsService.calculateResult(newGame);
		//Then		
		String calculatedResult = afterGame.getResult();
		Assert.assertNotNull(calculatedResult);
		Assert.assertEquals("Rock draws with Rock", calculatedResult);		
	}	
}

package uk.co.jamesmcguigan.rockpaperscissors.services;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jamesmcguigan.rockpaperscissors.builders.PlayerBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.models.Player;

public class GestureServiceTest {
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testReturnAListOfGestures()
	{
		//Given
		IGestureService gestureService = new GestureService();
		//When
		LinkedList<Gesture> gestures = gestureService.getAllGestures();
		//Then
		Assert.assertNotNull(gestures);
		Assert.assertEquals(3,gestures.size());				
	}

	@Test
	public void testReturnARandomGestureForPlayer()
	{
		//Given
		PlayerBuilder playerBuilder = new PlayerBuilder();
		playerBuilder.createPlayer();
		Player player1 = playerBuilder.getPlayer();
		playerBuilder = new PlayerBuilder();		
		playerBuilder.createPlayer();
		Player player2 = playerBuilder.getPlayer();
		playerBuilder = new PlayerBuilder();
		playerBuilder.createPlayer();
		Player player3 = playerBuilder.getPlayer();
		playerBuilder = new PlayerBuilder();
		playerBuilder.createPlayer();
		Player player4 = playerBuilder.getPlayer();
		playerBuilder = new PlayerBuilder();
		playerBuilder.createPlayer();
		Player player5 = playerBuilder.getPlayer();			
		IGestureService gestureService = new GestureService();		
		//When
		player1 = gestureService.generateGesture(player1);
		player2 = gestureService.generateGesture(player2);
		player3 = gestureService.generateGesture(player3);
		player4 = gestureService.generateGesture(player4);
		player5 = gestureService.generateGesture(player5);
		//Then
		Assert.assertFalse(player1.equals(player2)
				&& player2.equals(player3)
				&& player3.equals(player4)
				&& player4.equals(player5));				
	}	
	
}

package uk.co.jamesmcguigan.rockpaperscissors.controllers;

import java.util.LinkedList;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jamesmcguigan.rockpaperscissors.builders.GameBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.builders.GestureBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.models.Game;
import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.services.IGameService;
import uk.co.jamesmcguigan.rockpaperscissors.services.IGestureService;

import static org.easymock.EasyMock.*;

public class RockPaperScissorsControllerTest {

    private IGameService gameService;
    private IGestureService gestureService;

    @Before
    public void setUp() throws Exception {
        gameService = EasyMock.createMock(IGameService.class);
        gestureService = EasyMock.createMock(IGestureService.class);
    }

    @Test
    public void testReturnAResultOfAGame() {
        //Given
        GameBuilder gameBuilder = new GameBuilder();
        gameBuilder.createGame();
        Game game = gameBuilder.getGame();
        RockPaperScissorsController rockPaperScissorsController = new RockPaperScissorsController();
        expect(gameService.playGame(game)).andReturn(gameBuilder.getGame()).times(1);
        rockPaperScissorsController.setGameService(gameService);
        replay(gameService);
        //When
        Game outcomeFromGame = rockPaperScissorsController.playGame(game);
        //Then
        verify(gameService);
        Assert.assertNotNull(outcomeFromGame);
    }

    @Test
    public void testReturnAListOfAvailableGestures() {
        GestureBuilder gestureBuilder = new GestureBuilder();
        gestureBuilder.createGestureCollection();
        RockPaperScissorsController rockPaperScissorsController = new RockPaperScissorsController();
        expect(gestureService.getAllGestures()).andReturn(gestureBuilder.getGestures()).times(1);
        rockPaperScissorsController.setGestureService(gestureService);
        replay(gestureService);
        //When
        LinkedList<Gesture> gestures = rockPaperScissorsController.getGestures();
        //Then
        verify(gestureService);
        Assert.assertNotNull(gestures);
        Assert.assertEquals(3, gestures.size());
    }
}

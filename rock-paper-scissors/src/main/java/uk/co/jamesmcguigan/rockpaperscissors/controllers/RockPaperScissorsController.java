package uk.co.jamesmcguigan.rockpaperscissors.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uk.co.jamesmcguigan.rockpaperscissors.models.Game;
import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.services.IGameService;
import uk.co.jamesmcguigan.rockpaperscissors.services.IGestureService;

@Controller
public class RockPaperScissorsController {
    @Autowired
    private IGestureService gestureService;
    @Autowired
    private IGameService gameService;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/gesture/", method = RequestMethod.GET)
    @ResponseBody
    public LinkedList<Gesture> getGestures() {
        return gestureService.getAllGestures();
    }

    @RequestMapping(value = "/game/", method = RequestMethod.POST)
    @ResponseBody
    public Game playGame(@RequestBody final Game game) {
        return gameService.playGame(game);
    }

    public IGestureService getGestureService() {
        return gestureService;
    }

    public void setGestureService(final IGestureService gestureService) {
        this.gestureService = gestureService;
    }

    public IGameService getGameService() {
        return gameService;
    }

    public void setGameService(final IGameService gameService) {
        this.gameService = gameService;
    }
}

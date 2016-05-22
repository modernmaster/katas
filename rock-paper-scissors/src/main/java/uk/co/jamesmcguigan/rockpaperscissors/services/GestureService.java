package uk.co.jamesmcguigan.rockpaperscissors.services;

import uk.co.jamesmcguigan.rockpaperscissors.builders.GestureBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.models.Player;

import java.util.LinkedList;
import java.util.Random;

public class GestureService implements IGestureService {
    public LinkedList<Gesture> getAllGestures() {
        GestureBuilder gestureBuilder = new GestureBuilder();
        gestureBuilder.createGestureCollection();
        return gestureBuilder.getGestures();
    }

    public Player generateGesture(final Player player) {
        GestureBuilder gestureBuilder = new GestureBuilder();
        gestureBuilder.createGestureCollection();
        Random random = new Random();
        player.setGesture(gestureBuilder.getGestures().get(
                random.nextInt(gestureBuilder.getGestures().size())));
        return player;
    }
}

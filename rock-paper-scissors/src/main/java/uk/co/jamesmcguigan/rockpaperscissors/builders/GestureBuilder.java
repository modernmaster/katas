package uk.co.jamesmcguigan.rockpaperscissors.builders;

import java.util.LinkedList;

import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;

public class GestureBuilder {
    private final Gesture gestureRock = new Gesture("Rock");
    private final Gesture gesturePaper = new Gesture("Paper");
    private final Gesture gestureScissors = new Gesture("Scissors");
    private LinkedList<Gesture> gestures = new LinkedList<Gesture>();

    public void createGestureCollection() {
        LinkedList<Gesture> gestures = new LinkedList<Gesture>();
        gestures.add(gestureRock);
        gestures.add(gesturePaper);
        gestures.add(gestureScissors);
        this.gestures = gestures;
    }

    public LinkedList<Gesture> getGestures() {
        return gestures;
    }
}

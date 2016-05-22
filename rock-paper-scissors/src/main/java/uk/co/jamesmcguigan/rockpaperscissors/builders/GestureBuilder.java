package uk.co.jamesmcguigan.rockpaperscissors.builders;

import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;

import java.util.LinkedList;

public class GestureBuilder {
    private LinkedList<Gesture> gestures = new LinkedList<Gesture>();

    private Gesture gestureRock = new Gesture("Rock");
    private Gesture gesturePaper = new Gesture("Paper");
    private Gesture gestureScissors = new Gesture("Scissors");

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

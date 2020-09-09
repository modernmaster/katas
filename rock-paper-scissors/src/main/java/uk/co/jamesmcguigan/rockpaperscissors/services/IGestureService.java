package uk.co.jamesmcguigan.rockpaperscissors.services;

import java.util.LinkedList;

import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.models.Player;

public interface IGestureService {

    LinkedList<Gesture> getAllGestures();

    Player generateGesture(final Player player);
}

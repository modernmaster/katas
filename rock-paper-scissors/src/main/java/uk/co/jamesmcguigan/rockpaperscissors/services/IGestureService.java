package uk.co.jamesmcguigan.rockpaperscissors.services;

import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.models.Player;

import java.util.LinkedList;

public interface IGestureService {

    LinkedList<Gesture> getAllGestures();

    Player generateGesture(final Player player);
}

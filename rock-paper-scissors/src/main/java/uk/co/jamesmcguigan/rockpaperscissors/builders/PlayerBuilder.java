package uk.co.jamesmcguigan.rockpaperscissors.builders;

import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.models.Player;

public class PlayerBuilder {
    private Player player = new Player();
    private Gesture gesture = new Gesture("Rock");
    private Boolean isHuman = false;

    public Player getPlayer() {
        return player;
    }

    public void createPlayer() {
        this.player = new Player();
        this.player.setGesture(getGesture());
        this.player.setIsHuman(getIsHuman());
    }

    private Gesture getGesture() {
        return gesture;
    }

    public void setGesture(final Gesture gesture) {
        this.gesture = gesture;
    }

    private Boolean getIsHuman() {
        return isHuman;
    }

    public void setIsHuman(final Boolean isHuman) {
        this.isHuman = isHuman;
    }

}

package uk.co.jamesmcguigan.rockpaperscissors.models;

public class Player {
    private boolean isHuman;
    private Gesture gesture;

    public boolean getIsHuman() {
        return isHuman;
    }

    public void setIsHuman(final boolean isHuman) {
        this.isHuman = isHuman;
    }

    public Gesture getGesture() {
        return gesture;
    }

    public void setGesture(final Gesture gesture) {
        this.gesture = gesture;
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj==null || obj.getClass() != Player.class) {
            return false;
        }
        Player player = (Player) obj;
        return player.getIsHuman() == getIsHuman()
                && player.getGesture().getName().equals(getGesture().getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

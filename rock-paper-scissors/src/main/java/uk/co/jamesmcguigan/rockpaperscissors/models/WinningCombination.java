package uk.co.jamesmcguigan.rockpaperscissors.models;

public class WinningCombination {
    private Gesture winningGesture;
    private Gesture losingGesture;
    private String resultingAction;

    public Gesture getWinningGesture() {
        return winningGesture;
    }

    public void setWinningGesture(final Gesture player1) {
        this.winningGesture = player1;
    }

    public Gesture getLosingGesture() {
        return losingGesture;
    }

    public void setLosingGesture(final Gesture player2Gesture) {
        this.losingGesture = player2Gesture;
    }

    public String getResultingAction() {
        return resultingAction;
    }

    public void setResultingAction(final String resultingAction) {
        this.resultingAction = resultingAction;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winningGesture.getName());
        stringBuilder.append(" ");
        stringBuilder.append(resultingAction);
        stringBuilder.append(" ");
        stringBuilder.append(losingGesture.getName());
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

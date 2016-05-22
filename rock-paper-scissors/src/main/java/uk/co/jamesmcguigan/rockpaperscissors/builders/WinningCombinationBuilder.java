package uk.co.jamesmcguigan.rockpaperscissors.builders;

import uk.co.jamesmcguigan.rockpaperscissors.models.Gesture;
import uk.co.jamesmcguigan.rockpaperscissors.models.WinningCombination;

import java.util.LinkedList;

public class WinningCombinationBuilder {
    private LinkedList<WinningCombination> winningCombinations;
    private Gesture rock;
    private Gesture paper;
    private Gesture scissors;

    public WinningCombinationBuilder() {
        winningCombinations = new LinkedList<WinningCombination>();
        rock = new Gesture("rock");
        paper = new Gesture("paper");
        scissors = new Gesture("scissors");
    }

    public void createWinningCombination() {
        winningCombinations.add(createPaperWinningCombination());
        winningCombinations.add(createScissorsWinningCombination());
        winningCombinations.add(createRockWinningCombination());
    }

    public LinkedList<WinningCombination> getWinningCombinations() {
        return winningCombinations;
    }

    public void setWinningCombinations(
            final LinkedList<WinningCombination> winningCombinations) {
        this.winningCombinations = winningCombinations;
    }

    private WinningCombination createRockWinningCombination() {
        WinningCombination winningCombination = new WinningCombination();
        winningCombination.setWinningGesture(getRock());
        winningCombination.setLosingGesture(getScissors());
        winningCombination.setResultingAction("blunts");
        return winningCombination;
    }

    private WinningCombination createPaperWinningCombination() {
        WinningCombination winningCombination = new WinningCombination();
        winningCombination.setWinningGesture(getPaper());
        winningCombination.setLosingGesture(getRock());
        winningCombination.setResultingAction("wraps");
        return winningCombination;
    }

    private WinningCombination createScissorsWinningCombination() {
        WinningCombination winningCombination = new WinningCombination();
        winningCombination.setWinningGesture(getScissors());
        winningCombination.setLosingGesture(getPaper());
        winningCombination.setResultingAction("cuts");
        return winningCombination;
    }

    public Gesture getRock() {
        return rock;
    }

    public void setRock(final Gesture rock) {
        this.rock = rock;
    }

    public Gesture getPaper() {
        return paper;
    }

    public void setPaper(final Gesture paper) {
        this.paper = paper;
    }

    public Gesture getScissors() {
        return scissors;
    }

    public void setScissors(final Gesture scissors) {
        this.scissors = scissors;
    }
}

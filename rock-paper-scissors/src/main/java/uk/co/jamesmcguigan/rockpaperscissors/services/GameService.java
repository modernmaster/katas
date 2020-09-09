package uk.co.jamesmcguigan.rockpaperscissors.services;

import java.util.LinkedList;

import uk.co.jamesmcguigan.rockpaperscissors.builders.WinningCombinationBuilder;
import uk.co.jamesmcguigan.rockpaperscissors.models.Game;
import uk.co.jamesmcguigan.rockpaperscissors.models.WinningCombination;

public class GameService implements IGameService {
    private IGestureService gestureService;

    public Game playGame(final Game game) {
        if (!game.getPlayer1().getIsHuman()) {
            game.setPlayer1(gestureService.generateGesture(game.getPlayer1()));
        }
        if (!game.getPlayer2().getIsHuman()) {
            game.setPlayer2(gestureService.generateGesture(game.getPlayer2()));
        }
        return calculateResult(game);
    }

    public Game calculateResult(final Game game) {
        StringBuffer stringBuffer = new StringBuffer();
        if (isDrawnGame(game)) {
            stringBuffer.append(game.getPlayer1().getGesture().getName());
            stringBuffer.append(" draws with ");
            stringBuffer.append(game.getPlayer2().getGesture().getName());
            game.setResult(stringBuffer.toString());
            game.setWinner("It's a draw!");
        } else if (isPlayer1Winner(game)) {
            game.setWinner("Player 1 wins!");
        } else if (isPlayer2Winner(game)) {
            game.setWinner("Player 2 wins!");
        } else {
            stringBuffer.append(game.getPlayer1().getGesture().getName());
            stringBuffer.append(" unknown winning combination with ");
            stringBuffer.append(game.getPlayer2().getGesture().getName());
            game.setResult(stringBuffer.toString());
        }
        return game;
    }

    private Boolean isPlayer1Winner(final Game game) {
        WinningCombinationBuilder winningCombinationsBuilder = new WinningCombinationBuilder();
        winningCombinationsBuilder.createWinningCombination();
        LinkedList<WinningCombination> winningCombinations = winningCombinationsBuilder
                .getWinningCombinations();
        for (WinningCombination winningCombination : winningCombinations) {
            if (winningCombination.getWinningGesture().equals(
                    game.getPlayer1().getGesture())
                    && winningCombination.getLosingGesture().equals(
                    game.getPlayer2().getGesture())) {
                game.setResult(winningCombination.toString());
                return true;
            }
        }
        return false;
    }

    private Boolean isPlayer2Winner(final Game game) {
        WinningCombinationBuilder winningCombinationsBuilder = new WinningCombinationBuilder();
        winningCombinationsBuilder.createWinningCombination();
        LinkedList<WinningCombination> winningCombinations = winningCombinationsBuilder
                .getWinningCombinations();
        for (WinningCombination winningCombination : winningCombinations) {
            game.setResult(winningCombination.toString());
            if (winningCombination.getWinningGesture().equals(
                    game.getPlayer2().getGesture())
                    && winningCombination.getLosingGesture().equals(
                    game.getPlayer1().getGesture())) {
                game.setResult(winningCombination.toString());
                return true;
            }
        }
        return false;
    }

    private Boolean isDrawnGame(final Game game) {
        return game.getPlayer1().getGesture()
                .equals(game.getPlayer2().getGesture());
    }

    public IGestureService getGestureService() {
        return gestureService;
    }

    public void setGestureService(final IGestureService gestureService) {
        this.gestureService = gestureService;
    }

}

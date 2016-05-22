package uk.co.jamesmcguigan.rockpaperscissors.services;

import uk.co.jamesmcguigan.rockpaperscissors.models.Game;

public interface IGameService {

    Game playGame(final Game game);

    Game calculateResult(final Game game);
}

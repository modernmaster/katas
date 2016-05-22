Feature: Waste an Hour Having Fun
As a frequent games player,
I'd like to play rock, paper, scissors
so that I can spend an hour of my day having fun

Scenario: Can I play Player vs Computer 
Given a new game of rock, paper, scissors  
And I am Player 1 
And Player 2 is the Computer
When I play a game
Then an outcome from the game will be reached.

Scenario: Can I play Computer vs Computer?
Given a new game of rock, paper, scissors
And Player 1 is the Computer 
And Player 2 is the Computer
When I play a game
Then an outcome from the game will be reached.

Scenario: Can I play a different game each time?
Given a new game of rock, paper, scissors      
And a previous game ended with a successful outcome 
When I play a different game
Then a different outcome from the game will be reached.



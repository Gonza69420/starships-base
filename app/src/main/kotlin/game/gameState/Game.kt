package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed

interface Game {

    fun handleAction(keyMovement : KeyPressed) : Game
}
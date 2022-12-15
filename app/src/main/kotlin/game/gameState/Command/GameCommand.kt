package game.gameState.Command

import game.gameState.Game

interface GameCommand {
    fun execute(game : Game) : Game

    fun getKey () : String

    fun setKey( key : String) : GameCommand

    fun getPlayer() : Int
}
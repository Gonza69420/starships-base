package game.gameState.Command.Commands

import game.gameState.Command.GameCommand
import game.gameState.Game

class PauseGameCommand(private val key : String, private val player: Int) : GameCommand {
    override fun execute(game: Game): Game {
        TODO("Not yet implemented")
    }

    override fun getKey(): String {
        return key
    }

    override fun setKey(key : String): GameCommand {
        return PauseGameCommand(key, player)
    }

    override fun getPlayer(): Int {
        return player
    }
}
package game.gameState.Command.Commands

import game.gameState.Command.GameCommand
import game.gameState.Game
import game.gameState.PausedGame

class PauseGameCommand(private val key : String) : GameCommand {
    override fun execute(game: Game): Game {
        return PausedGame(key, game)
    }

    override fun getKey(): String {
        return key
    }

    override fun setKey(key : String): GameCommand {
        return PauseGameCommand(key)
    }

    override fun getPlayer(): Int {
        return 0
    }
}
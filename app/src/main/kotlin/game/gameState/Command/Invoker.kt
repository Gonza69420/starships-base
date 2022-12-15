package game.gameState.Command

import game.gameState.Game

class Invoker( private var commands : List<GameCommand>) {

    fun execute(command : String, game : Game) : Game {
        for (c in commands) {
            if (c.getKey() == command) {
                return c.execute(game)
            }
        }
        return game
    }

    fun changeKey(command : String, newKey : String) : Invoker {
        for (c in commands) {
            if (c.getKey() == command) {
                commands -= c
                c.setKey(newKey)
                commands += c
            }
        }
        return Invoker(commands)
    }

    fun addCommand(command : GameCommand) : Invoker {
        commands += command
        return Invoker(commands)
    }

}
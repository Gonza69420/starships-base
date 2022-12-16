package game.gameState.Command.Commands

import game.Entities.Bullet
import game.gameState.Command.GameCommand
import game.gameState.Game

class ShootCommand(private val key:String, private val player : Int) : GameCommand {
    override fun execute(game: Game): Game {
        var gamee : Game = game
        val bulletList = game.getShipController().shoot(game.getShip().get(player - 1), game.gameGetEntityNumber())
        gamee.setPlayer(player, game.getShip().get(player - 1).wasteAmmo())
        for (bullet in bulletList) {
            gamee = game.generateEntity(bullet)
        }
        return gamee
    }

    override fun getKey(): String {
        return key
    }

    override fun setKey(key: String): GameCommand {
        return ShootCommand(key, player)
    }

    override fun getPlayer(): Int {
        return player
    }
}
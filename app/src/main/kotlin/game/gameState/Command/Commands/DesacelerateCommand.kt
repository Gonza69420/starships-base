package game.gameState.Command.Commands

import game.Constants.Constants.Companion.SHIP_SPEED
import game.Entities.Ship
import game.gameState.Command.GameCommand
import game.gameState.Game

class DesacelerateCommand(private val key : String, private val player: Int) : GameCommand {
    override fun execute(game: Game): Game {
        val modifiedShip = game.getShipController().desacelerate(game.getShip().get(player - 1) , SHIP_SPEED)
        val shipList = game.getShip().toMutableList()
        shipList.set(player - 1, modifiedShip)
        return game.setShip(shipList)
    }

    override fun getKey(): String {
        return key
    }

    override fun setKey(key : String): GameCommand {
        return DesacelerateCommand(key, player)
    }

    override fun getPlayer(): Int {
        return player
    }
}

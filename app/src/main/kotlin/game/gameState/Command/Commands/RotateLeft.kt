package game.gameState.Command.Commands

import game.Constants.Constants
import game.Constants.Constants.Companion.SHIP_ROTATION_SPEED
import game.Entities.Ship
import game.gameState.Command.GameCommand
import game.gameState.Game

class RotateLeft(private val key : String, private val player : Int) : GameCommand {
    override fun execute(game: Game): Game {
        val modifiedShip = game.getShipController().rotateLeft(game.getShip().get(player - 1) , SHIP_ROTATION_SPEED)
        val shipList = game.getShip().toMutableList()
        shipList.set(player - 1, modifiedShip)
        return game.setShip(shipList)
    }

    override fun getKey(): String {
        return key
    }

    override fun setKey(key : String): GameCommand {
        return RotateLeft(key, player)
    }

    override fun getPlayer(): Int {
        return player
    }
}

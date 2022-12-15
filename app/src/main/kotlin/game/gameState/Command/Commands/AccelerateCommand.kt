package game.gameState.Command.Commands

import game.Constants.Constants
import game.Entities.Ship
import game.gameState.Command.GameCommand
import game.gameState.Game

class AccelerateCommand(private val key : String, private val player: Int) : GameCommand {
    override fun execute(game: Game): Game {
        val modifiedShip = game.getShipController().acelerate(game.getShip().get(player - 1) , Constants.SHIP_SPEED)
        val shipList = game.getShip().toMutableList()
        shipList.set(player - 1, modifiedShip)
        return game.setShip(shipList)
    }

    override fun getKey(): String {
        return key
    }

    override fun setKey(key : String): GameCommand {
        return AccelerateCommand(key, player)
    }

    override fun getPlayer(): Int {
        return player
    }


}
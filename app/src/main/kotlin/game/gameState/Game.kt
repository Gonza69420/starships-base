package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Entities.Moveable
import game.Entities.Ship
import game.Movement.ShipMovement

interface Game {

    fun handleAction(keyMovement : KeyPressed) : Game

    fun getShip() : List<Ship>

    fun getShipController() : ShipMovement

    fun gameGetEntityNumber () : Int

    fun generateEntity(entity : Moveable) : Game

    fun setShip (ship : List<Ship>) : Game
}
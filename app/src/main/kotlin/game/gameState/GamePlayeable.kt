package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Entities.Entity
import game.Entities.Moveable
import game.Entities.Ship
import game.Movement.ShipMovement
import game.gameState.Command.Invoker

class GamePlayeable (private val width : Double, private val height : Double, private val entities : List<Moveable>, private val ships : List<Ship>, private val points : Int, private var EntityNumber : Int,  private val invoker : Invoker) : Game  {
    private val shipController : ShipMovement = ShipMovement()

    override fun handleAction(keyMovement: KeyPressed): Game {
        return invoker.execute(keyMovement.key.char, this)
    }

    override fun getShip(): List<Ship> {
        return ships
    }

    override fun getShipController(): ShipMovement {
        TODO("Not yet implemented")
    }

    override fun gameGetEntityNumber(): Int {
        EntityNumber += 1
        return EntityNumber
    }

    override fun generateEntity(entity : Moveable) : Game {
        return GamePlayeable(width, height, entities.plus(entity), ships, points, EntityNumber, invoker)
    }

    override fun setShip(ship: List<Ship>): Game {
        return GamePlayeable(width, height, entities, ship, points, EntityNumber, invoker)
    }


}
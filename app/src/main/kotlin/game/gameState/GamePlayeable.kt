package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Entities.Entity
import game.Entities.Moveable
import game.Entities.Ship
import game.Movement.ShipMovement
import game.gameState.Command.Invoker

class GamePlayeable (private val width : Double, private val height : Double, private val entities : List<Moveable>, private val ships : List<Ship>, private val points : Int, private var EntityNumber : Int,  private val invoker : Invoker) : Game  {
    private val shipController : ShipMovement = ShipMovement()

    override fun handleAction(key : String): Game {
        return invoker.execute(key, this)
    }

    override fun getShip(): List<Ship> {
        return ships
    }

    override fun getShipController(): ShipMovement {
        return shipController
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

    override fun setInvoker(invoker: Invoker): Game {
        return GamePlayeable(width, height, entities, ships, points, EntityNumber, invoker)
    }

    override fun moveEntities(): Game {
        var entitiesList = entities.toMutableList()

        var shipList = ships.toMutableList()
        for (entity in entitiesList) {
            entitiesList.remove(entity)
            entitiesList.add(entity.updatePosition())
            if (entity.isOutOfBounds(width, height)) {
                entitiesList.remove(entity)
            }
        }
        for (ship in shipList) {
            shipList.remove(ship)
            shipList.add(ship.updatePosition())
        }
        return GamePlayeable(width, height, entitiesList, shipList, points, EntityNumber, invoker)
    }

    override fun getEntities(): List<Moveable> {
        return entities
    }


}
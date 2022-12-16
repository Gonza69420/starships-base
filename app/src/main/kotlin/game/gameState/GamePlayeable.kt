package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Constants.Constants
import game.Entities.Asteroid.Asteroid
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
        val entityList = entities.toMutableList()
        entityList.add(entity)
        if (entityList.size > Constants.MAXENTITIES || getNumberOfAsteroids(entityList) > Constants.MAXASTEROIDS ){
                return GamePlayeable(width, height, entities, ships, points, EntityNumber, invoker)
        }
        return GamePlayeable(width, height, entityList , ships, points, EntityNumber, invoker)
    }

    fun getNumberOfAsteroids(entityList : List<Moveable>) : Int {
        var numberOfAsteroids = 0
        for (entity in entityList) {
            if (entity.getType().equals("Asteroid")) {
                numberOfAsteroids += 1
            }
        }
        return numberOfAsteroids
    }

    override fun setShip(ship: List<Ship>): Game {
        return GamePlayeable(width, height, entities, ship, points, EntityNumber, invoker)
    }

    override fun setInvoker(invoker: Invoker): Game {
        return GamePlayeable(width, height, entities, ships, points, EntityNumber, invoker)
    }

    override fun moveEntities(): Game {
        var entitiesList = mutableListOf<Moveable>()
        var shipList = mutableListOf<Ship>()
        for (entity in entities) {
            if (!entity.isOutOfBounds(width, height)) {
            entitiesList.add(entity.updatePosition())
            }
        }
        for (ship in ships) {
            shipList.add(ship.updatePosition())
        }
        return GamePlayeable(width, height, entitiesList, shipList, points, EntityNumber, invoker)
    }

    override fun getEntities(): List<Moveable> {
        return entities
    }


}
package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Collision.Observable
import game.Constants.Constants
import game.Entities.Asteroid.Asteroid
import game.Entities.Entity
import game.Entities.Interfaces.Damageable
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
        entitiesList = eliminateDeadEntities(entitiesList).toMutableList()
       for (ship in ships) {
            shipList.add(ship.updatePosition())
        }
        return GamePlayeable(width, height, entitiesList, shipList, points, EntityNumber, invoker)
    }

    override fun getEntities(): List<Moveable> {
        return entities
    }

    override fun setPlayer(player: Int, ship: Ship): Game {
        val shipList = ships.toMutableList()
        shipList[player - 1] = ship
        return GamePlayeable(width, height, entities, shipList, points, EntityNumber, invoker)
    }

    override fun handleCollision(Entity1: Entity, Entity2: Entity): Game {
        var Points = points
        var entityList = entities.toMutableList()
        var shipList = ships.toMutableList()
        if (Entity1 is Observable && Entity2 is Moveable) {
            val modifiedEntity1 = Entity1.notifyObservers(Entity2)
            if (Entity1.getType().equals("Ship")) {
                shipList.remove(Entity1)
                shipList.add(modifiedEntity1 as Ship)
            }else {
                entityList.remove(Entity1)
                entityList.add(modifiedEntity1 as Moveable)
            }
                Points += 100
        }
            if (Entity2 is Observable && Entity1 is Moveable) {
                val modifiedEntity2 = Entity2.notifyObservers(Entity1)
                if (Entity2.getType().equals("Ship")) {
                    shipList.remove(Entity2)
                    shipList.add(modifiedEntity2 as Ship)
                }else{
                    entityList.remove(Entity2)
                    entityList.add(modifiedEntity2 as Moveable)
                    Points += 100
                }
            }
            return GamePlayeable(width, height, entityList, shipList, Points, EntityNumber, invoker)
    }

    override fun getEntityFromId(id: Int): Entity {
        for (entity in entities) {
            if (entity.getId() == id) {
                return entity
            }
        }
        for (ship in ships) {
            if (ship.getId() == id) {
                return ship
            }
        }
        return ships[0]
    }

    override fun getPoints(): Int {
        return points
    }

    fun eliminateDeadEntities( list : List<Moveable>) : List<Moveable>{
        var entityList = list.toMutableList()
        for (entity in list) {
            if (entity is Damageable && !entity.isAlive()) {
                entityList.remove(entity)
            }
        }
        return entityList
    }


}
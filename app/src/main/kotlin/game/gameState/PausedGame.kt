package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Entities.Entity
import game.Entities.Moveable
import game.Entities.Ship
import game.Movement.ShipMovement
import game.gameState.Command.Invoker

class PausedGame(private val unPauseKey : String, private val game : Game ) : Game {
    override fun handleAction(key : String): Game {
        if (key.equals(unPauseKey)) {
            return game
        }
        return this
    }

    override fun getShip(): List<Ship> {
        return listOf()
    }

    override fun getShipController(): ShipMovement {
        TODO("Not yet implemented")
    }

    override fun gameGetEntityNumber(): Int {
        return 0
    }

    override fun generateEntity(entity: Moveable): Game {
        TODO("Not yet implemented")
    }

    override fun setShip(ship: List<Ship>): Game {
        TODO("Not yet implemented")
    }

    override fun setInvoker(invoker: Invoker): Game {
        TODO("Not yet implemented")
    }

    override fun moveEntities(): Game {
        TODO("Not yet implemented")
    }

    override fun getEntities(): List<Moveable> {
        TODO("Not yet implemented")
    }

    override fun setPlayer(player: Int, ship: Ship): Game {
        TODO("Not yet implemented")
    }

    override fun handleCollision(Entity1: Entity, Entity2: Entity): Game {
        TODO("Not yet implemented")
    }

    override fun getEntityFromId(id: Int): Entity {
        TODO("Not yet implemented")
    }

    override fun getPoints(): Int {
        TODO("Not yet implemented")
    }
}
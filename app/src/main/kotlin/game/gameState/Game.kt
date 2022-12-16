package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Collision.Observable
import game.Entities.Entity
import game.Entities.Moveable
import game.Entities.Ship
import game.Movement.ShipMovement
import game.gameState.Command.Invoker

interface Game {

    fun handleAction(key : String) : Game

    fun getShip() : List<Ship>

    fun getShipController() : ShipMovement

    fun gameGetEntityNumber () : Int

    fun generateEntity(entity : Moveable) : Game

    fun setShip (ship : List<Ship>) : Game

    fun setInvoker (invoker : Invoker) : Game

    fun moveEntities() : Game

    fun getEntities() : List<Moveable>

    fun setPlayer (player: Int , ship : Ship) : Game

    fun handleCollision(Entity1 : Entity , Entity2: Entity) : Game

    fun getEntityFromId(id : Int) : Entity

    fun getPoints () : Int
}
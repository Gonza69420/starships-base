package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Entities.Moveable
import game.Entities.Ship
import game.Movement.ShipMovement
import game.gameState.Command.Invoker

class PausedGame : Game {
    override fun handleAction(key : String): Game {
        TODO("Not yet implemented")
    }

    override fun getShip(): List<Ship> {
        TODO("Not yet implemented")
    }

    override fun getShipController(): ShipMovement {
        TODO("Not yet implemented")
    }

    override fun gameGetEntityNumber(): Int {
        TODO("Not yet implemented")
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
}
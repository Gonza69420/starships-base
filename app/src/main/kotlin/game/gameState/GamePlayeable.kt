package game.gameState

import edu.austral.ingsis.starships.ui.KeyPressed
import game.Entities.Moveable
import game.Entities.Ship
import game.Movement.ShipMovement

class GamePlayeable (private val width : Double, private val height : Double, private val entities : List<Moveable>, private val ships : List<Ship>, private val points : Int) : Game  {
    private val shipController : ShipMovement = ShipMovement()

    override fun handleAction(keyMovement: KeyPressed): Game {
        TODO("Not yet implemented")
    }


}
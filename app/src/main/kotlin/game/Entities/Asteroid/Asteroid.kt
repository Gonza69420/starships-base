package game.Entities.Asteroid

import game.Entities.Asteroid.Strategy.Destroy.DestroyStrategy
import game.Position

class Asteroid(private val health : Double, private val position : Position, private val size : Double,
               private val initialPosition : Position, private val finalPosition: Position,
               private val points : Int, private val destroyStrategy: DestroyStrategy,
               private val velocity : Double
) {

}
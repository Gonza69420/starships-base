package game.Entities.Asteroid

import game.Entities.Asteroid.Strategy.Destroy.DestroyStrategy
import game.Entities.Moveable
import game.Position

class Asteroid(private val health : Double, private val size : Double,
               private val initialPosition : Position, private val finalPosition: Position,
               private val points : Int, private val destroyStrategy: DestroyStrategy,
               private val velocity : Double, position: Position, velocityX: Double, velocityY: Double, id: Int
) : Moveable(position, velocityX, velocityY, id) {

    fun getInitialPosition() : Position {
        return initialPosition
    }

    fun getFinalPosition() : Position {
        return finalPosition
    }

}
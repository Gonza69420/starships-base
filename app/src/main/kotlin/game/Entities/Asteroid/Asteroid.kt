package game.Entities.Asteroid

import game.Entities.Asteroid.Strategy.Destroy.DestroyStrategy
import game.Movement.Movement
import game.Entities.Interfaces.Damageable
import game.Entities.Interfaces.Harmful
import game.Entities.Moveable
import game.Position

class Asteroid(private val health : Double, private val size : Double,
               private val points : Int, private val destroyStrategy: DestroyStrategy<*>,
               private val asteroidMovement: Movement,
               position: Position, velocityX: Double, velocityY: Double, id: Int
) : Moveable(position, velocityX, velocityY, id), Damageable, Harmful {




    fun destroy() : List<*> {
        return destroyStrategy.destroy(this)
    }

    fun move() : Moveable {
        return asteroidMovement.move(this)
    }

    override fun getHealth(): Double {
        return health
    }

    override fun setHealth(health: Double): Damageable {
        return Asteroid(health, size, points, destroyStrategy, asteroidMovement,
            getPosition(), getVelocityX(), getVelocityY(), getId())
    }

    override fun getPoints(): Int {
        return points
    }


    override fun getDamage(): Double {
        return 10.0
    }

    fun getSize() : Double {
        return size
    }

    fun getMovementStrategy() : Movement {
        return asteroidMovement
    }

}
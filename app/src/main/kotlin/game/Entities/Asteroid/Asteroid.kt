package game.Entities.Asteroid

import game.Collision.Observable
import game.Collision.Observer
import game.Collision.Observers.DamageCollision
import game.Entities.Asteroid.Strategy.Destroy.DestroyStrategy
import game.Movement.Movement
import game.Entities.Interfaces.Damageable
import game.Entities.Interfaces.Harmful
import game.Entities.Moveable
import game.Position

class Asteroid(private val health: Double, private val size: Double,
               private val points: Int, private val destroyStrategy: DestroyStrategy<*>,
               private val asteroidMovement: Movement,
               position: Position, velocityX: Double, velocityY: Double, id: Int,
               private val observers: List<Observer<Damageable>>,
                private val observersMover : List<Observer<Moveable>>

) : Moveable(position, velocityX, velocityY, observersMover,id, "Asteroid"), Damageable, Harmful, Observable {


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
            getPosition(), getVelocityX(), getVelocityY(), getId(), observers , observersMover)
    }

    override fun getPoints(): Int {
        return points
    }


    override fun getDamage(): Double {
        return 10.0
    }

    override fun getSize() : Double {
        return size
    }

    fun getMovementStrategy() : Movement {
        return asteroidMovement
    }

    fun rotateAsteroid(radians : Double) : Asteroid {
        return Asteroid(health, size, points, destroyStrategy, asteroidMovement,
            Position(getPosition().getX(), getPosition().getY(), radians), getVelocityX(), getVelocityY(), getId(), observers, observersMover)
    }

    override fun isAlive() : Boolean {
        return health > 0
    }

    override fun updatePosition(): Moveable {
        return move()
    }

    override fun registerObserver(observer: Observer<*>) : Moveable{
        observers.plus(observer)
        return this
    }

    override fun removeObserver(observer: Observer<*>) : Moveable{
        observers.minus(observer)
        return this
    }

    override fun notifyObservers(collisionWith: Moveable): Moveable {
        var asteroid = this
        observers.forEach {
            asteroid = it.update(collisionWith, asteroid) as Asteroid
        }
        return asteroid
    }

    fun getObserverss(): List<Observer<Damageable>> {
        return observers
    }

    override fun getObservers(): List<Observer<Moveable>> {
        return observersMover
    }

}
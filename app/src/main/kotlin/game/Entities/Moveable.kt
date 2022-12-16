package game.Entities

import game.Collision.Observable
import game.Collision.Observer
import game.Constants.Constants
import game.Entities.Interfaces.Damageable
import game.Position

open class Moveable(private val position: Position, private val velocityX : Double, private val velocityY: Double, private val observers : List<Observer<Moveable>> , id: Int, type : String) :
    Entity(id , type) , Observable {

    fun getPosition() : Position {
        return position
    }

    fun getVelocityX() : Double {
        return velocityX
    }

    fun getVelocityY() : Double {
        return velocityY
    }

    fun getVelocity() : Double {
        return Math.sqrt(velocityX * velocityX + velocityY * velocityY)
    }

    open fun updatePosition() : Moveable {
        return Moveable(Position(position.getX() + velocityX, position.getY() + velocityY, position.getAngle()), velocityX, velocityY, getObservers(), getId(), getType())
    }

    fun rotate(radians : Double) : Moveable {
        return Moveable(Position(position.getX(), position.getY(), radians), velocityX, velocityY, getObservers(),  getId(), getType())
    }

    fun setVelocityX(velocityX : Double) : Moveable {
        return Moveable(position, velocityX, velocityY , getObservers(),  getId(), getType())
    }

    fun setVelocityY(velocityY : Double) : Moveable {
        return Moveable(position, velocityX, velocityY, getObservers(),  getId(), getType())
    }

    fun acelerate(velocityX : Double, velocityY : Double) : Moveable {
        if (isOutOfBounds(Constants.WIDTH, Constants.HEIGHT)){
            return null as Moveable
        }
        return Moveable(Position(getPosition().getX() + velocityX , getPosition().getY() + velocityY, getPosition().getAngle()), this.velocityX + velocityX, this.velocityY + velocityY, getObservers(),  getId(), getType())
    }

    fun isOutOfBounds(width: Double, height: Double): Boolean {
        return position.getX() < 0 || position.getX() > width || position.getY() < 0 || position.getY() > height
    }

    open fun getSize(): Double {
        return 70.0
    }

    override fun registerObserver(observer: Observer<*>): Moveable {
        val list = observers.toMutableList()
        list.add(observer as Observer<Moveable>)
        return Moveable(position, velocityX, velocityY, list, getId(), getType())
    }

    override fun removeObserver(observer: Observer<*>): Moveable {
        val list = observers.toMutableList()
        list.remove(observer)
        return Moveable(position, velocityX, velocityY, list, getId(), getType())
    }

    override fun notifyObservers(collisionWith: Moveable): Moveable {
        var moveable = this
        for (observer in observers){
            moveable = observer.update(collisionWith, moveable)
        }
        return moveable
    }

    override fun getObservers(): List<Observer<Moveable>> {
        return observers
    }

}
package game.Entities

import game.Collision.Observable
import game.Collision.Observer
import game.Constants.Constants
import game.Entities.Interfaces.Harmful
import game.Movement.Movement
import game.Position

class Bullet(private val damage: Double, private val sizeX : Double, private val sizeY : Double, private val initialVelocity : Double,
             position: Position, velocityX: Double, velocityY: Double, id: Int, type:String, private val observers: List<Observer<Moveable>>
) :
    Moveable(position, velocityX, velocityY,observers ,id, type), Harmful {



    fun getSizeX(): Double {
        return sizeX
    }

    fun getSizeY(): Double {
        return sizeY
    }

    override fun getDamage(): Double {
        return damage.toDouble()
    }

    override fun updatePosition() : Moveable {
        if (isOutOfBounds(Constants.WIDTH , Constants.HEIGHT)){
            return null as Moveable
        }
        return Bullet(damage, sizeX, sizeY, initialVelocity,Position(getPosition().getX() + getVelocityX() * Math.sin(getPosition().getAngle()), getPosition().getY() - getVelocityY() * Math.cos(getPosition().getAngle()), getPosition().getAngle()), initialVelocity, initialVelocity, getId(), getType(), getObservers())
    }

    override fun getObservers(): List<Observer<Moveable>> {
        return super.getObservers()
    }


}
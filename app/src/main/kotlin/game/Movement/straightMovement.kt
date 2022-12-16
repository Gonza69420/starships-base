package game.Movement

import game.Entities.Moveable
import game.Position

class straightMovement(val acceleration : Double, val initialVelocity : Double, private val initialPosition : Position, private val finalPosition: Position) :
    Movement {

    override fun move(moveable: Moveable): Moveable {
        return if (moveable.getVelocityX() == 0.0 && moveable.getVelocityY() == 0.0) {
            moveable.setVelocityY(getInitialVelocityY())
        }else{
            accelerate(moveable)
        }
    }


    fun accelerate(moveable:  Moveable) : Moveable {
        return moveable.acelerate(moveable.getVelocityX() * acceleration , moveable.getVelocityY() * acceleration)
    }

    fun getAngle() : Double {
        val getSide = Math.abs(initialPosition.getX() - finalPosition.getX())
        val getOpposite = Math.abs(initialPosition.getY() - finalPosition.getY())

        return Math.atan((getSide / getOpposite).toDouble())
    }

    fun getInitialVelocityX() : Double {
        return initialVelocity * Math.cos(getAngle())
    }

    fun getInitialVelocityY() : Double {
        return initialVelocity * Math.sin(getAngle())
    }

    fun getAceleration() : Double {
        return acceleration
    }

    fun getFinalPosition() : Position {
        return finalPosition
    }


}
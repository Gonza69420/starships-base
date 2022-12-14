package game.Entities

import game.Position

open class Moveable(private val position: Position, private val velocityX : Double, private val velocityY: Double, id: Int) : Entity(
    id
) {

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

    fun updatePosition() : Moveable {
        return Moveable(Position(position.getX() + velocityX, position.getY() + velocityY), velocityX, velocityY, getId())
    }

    fun rotate(radians : Double) : Moveable {
        return Moveable(Position(position.getX(), position.getY(), position.getRadians() + radians), velocityX, velocityY, getId())
    }

    fun setVelocityX(velocityX : Double) : Moveable {
        return Moveable(position, velocityX, velocityY, getId())
    }

    fun setVelocityY(velocityY : Double) : Moveable {
        return Moveable(position, velocityX, velocityY, getId())
    }





}
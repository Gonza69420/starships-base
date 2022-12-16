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

    open fun updatePosition() : Moveable {
        return Moveable(Position(position.getX() + velocityX, position.getY() + velocityY), velocityX, velocityY, getId())
    }

    fun rotate(radians : Double) : Moveable {
        return Moveable(Position(position.getX(), position.getY(), position.getAngle() + radians), velocityX, velocityY, getId())
    }

    fun setVelocityX(velocityX : Double) : Moveable {
        return Moveable(position, velocityX, velocityY, getId())
    }

    fun setVelocityY(velocityY : Double) : Moveable {
        return Moveable(position, velocityX, velocityY, getId())
    }

    fun acelerate(velocityX : Double, velocityY : Double) : Moveable {
        return Moveable(position, this.velocityX + velocityX, this.velocityY + velocityY, getId())
    }

    fun isOutOfBounds(width: Double, height: Double): Boolean {
        return position.getX() < 0 || position.getX() > width || position.getY() < 0 || position.getY() > height
    }

}
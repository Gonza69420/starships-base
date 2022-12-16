package game.Entities

import game.Position

open class Moveable(private val position: Position, private val velocityX : Double, private val velocityY: Double, id: Int, type : String) :
    Entity(id , type) {

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
        return Moveable(Position(position.getX() + velocityX, position.getY() + velocityY, position.getAngle()), velocityX, velocityY, getId(), getType())
    }

    fun rotate(radians : Double) : Moveable {
        return Moveable(Position(position.getX(), position.getY(), radians), velocityX, velocityY, getId(), getType())
    }

    fun setVelocityX(velocityX : Double) : Moveable {
        return Moveable(position, velocityX, velocityY, getId(), getType())
    }

    fun setVelocityY(velocityY : Double) : Moveable {
        return Moveable(position, velocityX, velocityY, getId(), getType())
    }

    fun acelerate(velocityX : Double, velocityY : Double) : Moveable {
        return Moveable(Position(getPosition().getX() + velocityX , getPosition().getY() + velocityY, getPosition().getAngle()), this.velocityX + velocityX, this.velocityY + velocityY, getId(), getType())
    }

    fun isOutOfBounds(width: Double, height: Double): Boolean {
        return position.getX() < 0 || position.getX() > width || position.getY() < 0 || position.getY() > height
    }

    open fun getSize(): Double {
        return 70.0
    }


}
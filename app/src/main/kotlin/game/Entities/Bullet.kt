package game.Entities

import game.Position

class Bullet(private val velocity: Int, private val damage: Int, private val sizeX : Double, private val sizeY : Double,
             position: Position, velocityX: Double, velocityY: Double, id: Int
) :
    Moveable(position, velocityX, velocityY, id) {

    fun getVelocity(): Int {
        return velocity
    }

    fun getDamage(): Int {
        return damage
    }

    fun getSizeX(): Double {
        return sizeX
    }

    fun getSizeY(): Double {
        return sizeY
    }

}
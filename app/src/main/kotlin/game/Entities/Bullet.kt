package game.Entities

import game.Movement.Movement
import game.Position

class Bullet(private val damage: Int, private val sizeX : Double, private val sizeY : Double, private val movement : Movement,
             position: Position, velocityX: Double, velocityY: Double, id: Int
) :
    Moveable(position, velocityX, velocityY, id) {

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
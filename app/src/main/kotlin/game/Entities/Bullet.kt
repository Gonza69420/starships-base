package game.Entities

import game.Entities.Interfaces.Harmful
import game.Movement.Movement
import game.Position

class Bullet(private val damage: Double, private val sizeX : Double, private val sizeY : Double, private val movement : Movement,
             position: Position, velocityX: Double, velocityY: Double, id: Int
) :
    Moveable(position, velocityX, velocityY, id), Harmful {



    fun getSizeX(): Double {
        return sizeX
    }

    fun getSizeY(): Double {
        return sizeY
    }

    override fun getDamage(): Double {
        return damage.toDouble()
    }

}
package game.Entities

import game.Entities.Gun.Gun
import game.Movement.Movement
import game.Position

class PowerUp( private val gun : Gun, private val movement: Movement ,position: Position, velocityX: Double, velocityY: Double, id: Int) : Moveable(position, velocityX, velocityY, id) {

    fun getGun() : Gun {
        return gun
    }

    fun getMovement() : Movement {
        return movement
    }

    fun setGun(ship : Ship) : Ship {
        return Ship(gun, ship.getHealth() ,ship.getPosition(), ship.getVelocityX(), ship.getVelocityY(), ship.getId())
    }


}
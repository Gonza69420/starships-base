package game.Entities

import game.Entities.Gun.Gun
import game.Position

class Ship(private val gun : Gun, position: Position, velocityX: Double, velocityY: Double, id: Int) : Moveable(position, velocityX,
    velocityY,
    id
) {

    fun setGun(gun : Gun) : Ship {
        return Ship(gun, getPosition(), getVelocityX(), getVelocityY(), getId())
    }

    fun shoot() : List<Bullet> {
        return gun.shoot()
    }

    fun getGun() : Gun {
        return gun
    }
}
package game.Entities

import game.Entities.Gun.Gun
import game.Entities.Interfaces.Damageable
import game.Position

class Ship(private val gun : Gun, private val health : Double, position: Position, velocityX: Double, velocityY: Double, id: Int) : Moveable(position, velocityX,
    velocityY,
    id
) , Damageable{

    fun setGun(gun : Gun) : Ship {
        return Ship(gun, health, getPosition(), getVelocityX(), getVelocityY(), getId())
    }

    fun shoot(id : Int) : List<Bullet> {
        return gun.shoot(getPosition(), id)
    }

    fun getGun() : Gun {
        return gun
    }

    override fun getHealth(): Double {
        return health
    }

    override fun setHealth(health: Double): Damageable {
        return Ship(gun, health, getPosition(), getVelocityX(), getVelocityY(), getId())
    }

    override fun getPoints(): Int {
        return 0
    }
}
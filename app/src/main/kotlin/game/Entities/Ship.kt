package game.Entities

import game.Constants.Constants
import game.Entities.Gun.Gun
import game.Entities.Interfaces.Damageable
import game.Position

class Ship(private val gun : Gun, private val health : Double, position: Position, velocityX: Double, velocityY: Double, id: Int) : Moveable(position, velocityX,
    velocityY,
    id,
    "Ship"
) , Damageable{

    fun setGun(gun : Gun) : Ship {
        return Ship(gun, health, getPosition(), getVelocityX(), getVelocityY(), getId())
    }

    fun shoot(id : Int) : List<Bullet> {
        return gun.shoot(getPosition(), id)
    }

    fun wasteAmmo() : Ship {
        return Ship(gun.wasteAmmo(), health, getPosition(), getVelocityX(), getVelocityY(), getId())
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

    override fun updatePosition() : Ship {
        if (isOutOfBounds(Constants.WIDTH , Constants.HEIGHT)){
            return Ship(gun, health, Position(Math.abs((Constants.WIDTH - 100 ) - getPosition().getX() ), Math.abs((Constants.HEIGHT - 100 ) - getPosition().getY()), getPosition().getAngle()  ), getVelocityX() * 0.2,    getVelocityY() * 0.2, getId())
        }
        return Ship(gun, health, Position(getPosition().getX() + getVelocityX() , getPosition().getY() + getVelocityY() , getPosition().getAngle()), getVelocityX(), getVelocityY(), getId())
    }
}
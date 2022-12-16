package game.Entities

import game.Collision.Observable
import game.Collision.Observer
import game.Constants.Constants
import game.Entities.Asteroid.Asteroid
import game.Entities.Gun.Gun
import game.Entities.Interfaces.Damageable
import game.Position

class Ship(private val gun : Gun, private val health : Double, position: Position, velocityX: Double, velocityY: Double, id: Int, private val observers : List<Observer<Moveable>>,
) : Moveable(position, velocityX,
    velocityY,
    observers,
    id,
    "Ship"
) , Damageable, Observable{

    fun setGun(gun : Gun) : Ship {
        return Ship(gun, health, getPosition(), getVelocityX(), getVelocityY(), getId(), observers )
    }

    fun shoot(id : Int) : List<Bullet> {
        return gun.shoot(getPosition(), id)
    }

    fun wasteAmmo() : Ship {
        return Ship(gun.wasteAmmo(), health, getPosition(), getVelocityX(), getVelocityY(), getId(), observers)
    }

    fun getGun() : Gun {
        return gun
    }

    override fun getHealth(): Double {
        return health
    }

    override fun setHealth(healthh: Double): Damageable {
        return Ship(gun, healthh, getPosition(), getVelocityX(), getVelocityY(), getId(), observers)
    }

    override fun getPoints(): Int {
        return 0
    }

    override fun isAlive(): Boolean {
        return health > 0
    }

    override fun updatePosition() : Ship {
        if (isOutOfBounds(Constants.WIDTH , Constants.HEIGHT)){
            return Ship(gun, health, Position(Math.abs((Constants.WIDTH - 100 ) - getPosition().getX() ), Math.abs((Constants.HEIGHT - 100 ) - getPosition().getY()), getPosition().getAngle()  ), getVelocityX() * 0.2,    getVelocityY() * 0.2, getId(), observers)
        }
        return Ship(gun, health, Position(getPosition().getX() + getVelocityX() , getPosition().getY() + getVelocityY() , getPosition().getAngle()), getVelocityX(), getVelocityY(), getId(), observers)
    }

    override fun registerObserver(observer: Observer<*>) : Moveable {
        val list = observers.toMutableList()
        list.add(observer as Observer<Moveable>)
        return Ship(gun, health, getPosition(), getVelocityX(), getVelocityY(), getId(), list)
    }

    override fun removeObserver(observer: Observer<*>): Moveable {
        val list = observers.toMutableList()
        list.remove(observer)
        return Ship(gun, health, getPosition(), getVelocityX(), getVelocityY(), getId(), list)
    }

    override fun notifyObservers(collisionWith: Moveable): Moveable {
        var ship = this
        observers.forEach {
            ship = it.update(collisionWith, ship) as Ship
        }
        return ship
    }

    override fun getObservers() : List<Observer<Moveable>> {
        return observers
    }


}
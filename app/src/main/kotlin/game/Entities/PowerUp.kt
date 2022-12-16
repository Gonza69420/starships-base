package game.Entities

import game.Collision.Observer
import game.Entities.Gun.Gun
import game.Position

class PowerUp(private val gun: Gun, position: Position, velocityY: Double, id : Int, observers : List<Observer<Moveable>>) : Moveable(position, 0.0, velocityY, observers,id, "PowerUp") {

    fun getGun() : Gun {
        return gun
    }

    fun setGun(ship : Ship) : Ship {
        return Ship(gun, ship.getHealth() ,ship.getPosition(), ship.getVelocityX(), ship.getVelocityY(), ship.getId(), ship.getObservers())
    }

    override fun updatePosition() : PowerUp {
        return PowerUp(gun, Position(getPosition().getX(), getPosition().getY() - getVelocityY(), getPosition().getAngle()), getVelocityY(), getId(), getObservers())
    }

    override fun registerObserver(observer: Observer<*>): Moveable {
        TODO("Not yet implemented")
    }

    override fun removeObserver(observer: Observer<*>): Moveable {
        TODO("Not yet implemented")
    }

    override fun notifyObservers(collisionWith: Moveable): Moveable {
        TODO("Not yet implemented")
    }

    override fun getObservers(): List<Observer<Moveable>> {
        TODO("Not yet implemented")
    }

}
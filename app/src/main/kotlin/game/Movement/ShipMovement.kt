package game.Movement

import game.Entities.Bullet
import game.Entities.Ship

class ShipMovement {

    fun rotateLeft(ship : Ship) : Ship{
        return Ship( ship.getGun(), ship.rotate( ship.getPosition().getRadians() + 1).getPosition(), ship.getVelocityX(), ship.getVelocityY(), ship.getId())
    }

    fun rotateRight (ship : Ship) : Ship{
        return Ship( ship.getGun(), ship.rotate( ship.getPosition().getRadians() - 1).getPosition(), ship.getVelocityX(), ship.getVelocityY(), ship.getId())
    }

    fun desacelerate(ship : Ship) : Ship {
        return Ship(ship.getGun(), ship.getPosition(), ship.getVelocityX() - 0.1 * Math.cos(ship.getPosition().getRadians()), ship.getVelocityY() - 0.1 * Math.sin(ship.getPosition().getRadians()), ship.getId())
    }

    fun acelerate(ship : Ship) : Ship {
        return Ship(ship.getGun(), ship.getPosition(), ship.getVelocityX() + 0.1 * Math.cos(ship.getPosition().getRadians()), ship.getVelocityY() + 0.1 * Math.sin(ship.getPosition().getRadians()), ship.getId())
    }

    fun shoot(ship : Ship) : List<Bullet> {
        return ship.shoot()
    }
}
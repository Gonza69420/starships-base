package game.Movement

import game.Entities.Bullet
import game.Entities.Ship

class ShipMovement {

    fun rotateLeft(ship : Ship, radians : Double) : Ship{
        return Ship( ship.getGun(), ship.getHealth() ,ship.rotate( ship.getPosition().getAngle() + radians).getPosition(), ship.getVelocityX(), ship.getVelocityY(), ship.getId(), ship.getObservers())
    }

    fun rotateRight (ship : Ship, radians : Double) : Ship{
        return Ship( ship.getGun(),ship.getHealth(), ship.rotate( ship.getPosition().getAngle() - radians).getPosition(), ship.getVelocityX(), ship.getVelocityY(), ship.getId(), ship.getObservers())
    }

    fun desacelerate(ship : Ship, desacelerate : Double) : Ship {
        return Ship(ship.getGun(),ship.getHealth(), ship.getPosition(), ship.getVelocityX() - desacelerate * Math.sin(ship.getPosition().getAngle()), ship.getVelocityY() + desacelerate * Math.cos(ship.getPosition().getAngle()), ship.getId(), ship.getObservers())
    }

    fun acelerate(ship : Ship, acelerate : Double) : Ship {
        return Ship(ship.getGun(),ship.getHealth(), ship.getPosition(), ship.getVelocityX() + acelerate * Math.sin(ship.getPosition().getAngle()), ship.getVelocityY() - acelerate * Math.cos(ship.getPosition().getAngle()), ship.getId(), ship.getObservers())
    }

    fun shoot(ship : Ship, id : Int) : List<Bullet> {
        return ship.shoot(id)
    }

    fun wasteAmmo(ship : Ship) : Ship {
        return ship.wasteAmmo()
    }
}
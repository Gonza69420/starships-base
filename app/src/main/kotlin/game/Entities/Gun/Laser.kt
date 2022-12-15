package game.Entities.Gun

import game.Constants.Constants
import game.Entities.Bullet
import game.Entities.Entity
import game.Entities.Moveable
import game.Geometry
import game.Movement.straightMovement
import game.Position

class Laser(private val ammo: Int, id: Int) : Gun, Entity(id) {
    override fun getBullet(): Bullet {
        return Bullet(Constants.LASER_DAMAGE, Constants.LASER_SIZEX, Constants.LASER_SIZEY,straightMovement( 0.0, Constants.LASER_SPEED , Position(0.0, 0.0), Position(10.0,10.0)), Position(0.0, 0.0), 0.0, 0.0, 0)
    }

    override fun getAmmo(): Int {
        TODO("Not yet implemented")
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        return listOf(Bullet(getBullet().getDamage(), getBullet().getSizeX(), getBullet().getSizeY(), straightMovement(0.0 , Constants.LASER_SPEED , position, Geometry().fromInitialPointGetFinalPoint(position) ), position, 0.0, 0.0, id ))
    }

    override fun wasteAmmo(): Gun {
        if (ammo > 0) {
            return Laser(ammo - 1, getId())
        } else {
            return normalGun(getId(), 0,1)
        }
    }


}
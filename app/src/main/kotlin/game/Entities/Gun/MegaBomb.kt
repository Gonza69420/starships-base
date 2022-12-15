package game.Entities.Gun

import game.Constants.Constants
import game.Entities.Bullet
import game.Entities.Entity
import game.Geometry
import game.Movement.straightMovement
import game.Position

class MegaBomb(private val ammo : Int, private val screenXSize : Double, private val screenYSize: Double, id: Int) : Gun,
    Entity(id) {
    override fun getBullet(): Bullet {
        return Bullet(
            Constants.BOMB_DAMAGE, Constants.BOMB_SIZEX, Constants.BOMB_SIZEY,
            straightMovement( 0.0, Constants.BOMB_SPEED , Position(0.0, 0.0), Position(10.0,10.0)), Position(0.0, 0.0), 0.0, 0.0, 0)

    }

    override fun getAmmo(): Int {
        return ammo
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        return listOf(Bullet(getBullet().getDamage(), getBullet().getSizeX(), getBullet().getSizeY(), straightMovement(0.0 , Constants.BOMB_SPEED , position, Geometry().fromInitialPointGetFinalPoint(position) ), position, 0.0, 0.0, id ))
    }

    override fun wasteAmmo(): Gun {
        if (ammo > 0) {
            return MegaBomb(ammo - 1, screenXSize, screenYSize, getId())
        } else {
            return normalGun(getId(), 0,1)
        }    }


}
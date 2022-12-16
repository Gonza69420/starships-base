package game.Entities.Gun

import game.Constants.Constants
import game.Entities.Bullet
import game.Entities.Entity
import game.Geometry
import game.Movement.straightMovement
import game.Position

class MegaBomb(private val ammo : Int, private val screenXSize : Double, private val screenYSize: Double, id: Int) : Gun,
    Entity(id, "Bomb") {
    override fun getBullet(): Bullet {
        return Bullet(
            Constants.BOMB_DAMAGE, Constants.BOMB_SIZEX, Constants.BOMB_SIZEY,
            Constants.BOMB_SPEED, Position(0.0, 0.0), 0.0, 0.0, 0, "Bomb")

    }

    override fun getAmmo(): Int {
        return ammo
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        return listOf(Bullet(getBullet().getDamage(), getBullet().getSizeX(), getBullet().getSizeY(), Constants.BOMB_SPEED, position, Constants.BOMB_SPEED, Constants.BOMB_SPEED, id , "Bomb"))
    }

    override fun wasteAmmo(): Gun {
        if (ammo > 0) {
            return MegaBomb(ammo - 1, screenXSize, screenYSize, getId())
        } else {
            return normalGun(getId(), 0,1)
        }    }


}
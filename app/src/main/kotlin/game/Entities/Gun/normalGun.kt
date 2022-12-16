package game.Entities.Gun

import game.Constants.Constants
import game.Movement.straightMovement
import game.Entities.Bullet
import game.Entities.Entity
import game.Geometry
import game.Position

class normalGun(id: Int, private val ammo : Int, private val guns : Int) : Gun, Entity(id, "normalBullet") {
    override fun getBullet(): Bullet {
        return Bullet(Constants.BULLET_DAMAGE, Constants.BULLET_SIZEX, Constants.BULLET_SIZEY,Constants.BULLET_SPEED, Position(0.0, 0.0), 0.0, 0.0, 0, "normalBullet")
    }

    override fun getAmmo(): Int {
        return ammo
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        val list = mutableListOf<Bullet>()
        for (i in 1..guns) {
            list.add(Bullet(getBullet().getDamage(), getBullet().getSizeX(), getBullet().getSizeY(),Constants.BULLET_SPEED, position, 0.0, 0.0, id + i, "normalBullet"))
        }
        return list
    }

    override fun wasteAmmo(): Gun {
        return normalGun(getId(), ammo - 1, guns)
    }
}
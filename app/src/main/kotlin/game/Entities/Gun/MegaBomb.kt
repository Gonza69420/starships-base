package game.Entities.Gun

import game.Entities.Bullet
import game.Entities.Entity
import game.Position

class MegaBomb(private val ammo : Int, private val screenXSize : Double, private val screenYSize: Double, id: Int) : Gun,
    Entity(id) {
    override fun getBullet(): Bullet {
        TODO("Not yet implemented")
    }

    override fun getAmmo(): Int {
        return ammo
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        TODO("Not yet implemented")
    }

    override fun wasteAmmo(): Gun {
        if (ammo > 0) {
            return MegaBomb(ammo - 1, screenXSize, screenYSize, getId())
        } else {
            return normalGun(getId(), 0,1)
        }    }


}
package game.Entities.Gun

import game.Entities.Bullet
import game.Entities.Entity
import game.Entities.Moveable
import game.Position
import sun.awt.windows.ThemeReader.getPosition

class Laser(private val ammo: Int, id: Int) : Gun, Entity(id) {
    override fun getBullet(): Bullet {
        TODO("Not yet implemented")
    }

    override fun getAmmo(): Int {
        TODO("Not yet implemented")
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        TODO("Not yet implemented")
    }

    override fun wasteAmmo(): Gun {
        if (ammo > 0) {
            return Laser(ammo - 1, getId())
        } else {
            return normalGun(getId(), 0,1)
        }
    }


}
package game.Entities.Gun

import game.Entities.Bullet
import game.Entities.Entity

class normalGun(id: Int) : Gun, Entity(id) {
    override fun getBullet(): Bullet {
        TODO("Not yet implemented")
    }

    override fun getAmmo(): Int {
        TODO("Not yet implemented")
    }

    override fun shoot(): List<Bullet> {
        TODO("Not yet implemented")
    }
}
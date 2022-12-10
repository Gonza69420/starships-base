package game.Entities.Gun

import game.Entities.Bullet

class MegaBomb(private val ammo : Int, private val screenXSize : Double , private val screenYSize: Double) : Gun {
    override fun getBullet(): Bullet {
        return Bullet(100 , 1000000, screenXSize, screenYSize)
    }

    override fun getAmmo(): Int {
        return ammo
    }

    override fun shoot(): List<Bullet> {
        TODO("Not yet implemented")
    }
}
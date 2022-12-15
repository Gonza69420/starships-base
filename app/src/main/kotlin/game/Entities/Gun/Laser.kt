package game.Entities.Gun

import game.Entities.Bullet
import game.Entities.Entity
import game.Entities.Moveable
import game.Position

class Laser(private val ammo: Int, position: Position, id: Int) : Gun, Entity(id) {
    override fun getBullet(): Bullet {
        TODO("Not yet implemented")
    }

    override fun getAmmo(): Int {
        TODO("Not yet implemented")
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        TODO("Not yet implemented")
    }


}
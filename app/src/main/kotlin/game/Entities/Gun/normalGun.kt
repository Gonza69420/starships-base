package game.Entities.Gun

import game.Movement.straightMovement
import game.Entities.Bullet
import game.Entities.Entity
import game.Geometry
import game.Position

class normalGun(id: Int, private val ammo : Int, private val guns : Int) : Gun, Entity(id) {
    override fun getBullet(): Bullet {
        return Bullet(1.0, 1.0, 1.0, straightMovement( 0.0, 20.0 , Position(0.0, 0.0), Position(10.0,10.0)), Position(0.0, 0.0), 0.0, 0.0, 0)
    }

    override fun getAmmo(): Int {
        return ammo
    }

    override fun shoot(position: Position, id : Int): List<Bullet> {
        val list = listOf<Bullet>()
        for (i in 0..guns) {
            list.plus(Bullet(getBullet().getDamage(), getBullet().getSizeX(), getBullet().getSizeY(), straightMovement(0.0 , 10.0 , position, Geometry().fromInitialPointGetFinalPoint(position) ), position, 0.0, 0.0, id + i))
        }
        return list
    }

    override fun wasteAmmo(): Gun {
        return normalGun(getId(), ammo - 1, guns)
    }
}
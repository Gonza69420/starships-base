package game.Entities.Gun

import game.Entities.Bullet

interface Gun {
    fun getBullet() : Bullet
    fun getAmmo() : Int

    fun shoot() : List<Bullet>
}
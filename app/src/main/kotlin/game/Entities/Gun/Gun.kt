package game.Entities.Gun

import game.Entities.Bullet
import game.Entities.Entity

interface Gun  {
    fun getBullet() : Bullet
    fun getAmmo() : Int

    fun shoot() : List<Bullet>
}
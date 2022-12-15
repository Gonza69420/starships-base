package game.Entities.Gun

import game.Entities.Bullet
import game.Entities.Entity
import game.Position

interface Gun  {
    fun getBullet() : Bullet
    fun getAmmo() : Int

    fun shoot(position : Position, id : Int) : List<Bullet>

    fun wasteAmmo() : Gun
}
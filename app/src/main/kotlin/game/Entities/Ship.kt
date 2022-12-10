package game.Entities

import game.Entities.Gun.Gun

class Ship(private val gun : Gun) {

    fun setGun(gun : Gun) : Ship {
        return Ship(gun)
    }
}
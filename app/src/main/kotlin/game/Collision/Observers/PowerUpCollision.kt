package game.Collision.Observers

import game.Collision.Observable
import game.Collision.Observer
import game.Entities.Moveable
import game.Entities.PowerUp
import game.Entities.Ship

class PowerUpCollision : Observer<Moveable> {

    override fun update(collisionWith: Moveable, obvervable: Moveable) : Moveable {
        if (collisionWith is Ship && obvervable is PowerUp) {
            return obvervable.setGun(collisionWith)
        }
        return obvervable
    }
}

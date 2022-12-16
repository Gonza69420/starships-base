package game.Collision.Observers

import game.Collision.Observer
import game.Entities.Moveable
import game.Entities.PowerUp
import game.Entities.Ship

class PowerUpCollision : Observer<Moveable> {

    override fun update(collisionWith: Moveable, observable: Moveable) : Moveable {
        if (collisionWith is Ship && observable is PowerUp) {
            return observable.setGun(collisionWith)
        }
        return observable
    }
}

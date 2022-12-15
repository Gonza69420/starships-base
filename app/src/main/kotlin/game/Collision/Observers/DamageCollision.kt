package game.Collision.Observers

import game.Collision.Observer
import game.Entities.Interfaces.Damageable
import game.Entities.Interfaces.Harmful
import game.Entities.Moveable

class DamageCollision() : Observer<Damageable> {

    override fun update(collisionWith: Moveable, obvervable: Damageable) : Damageable {
        if (collisionWith is Harmful) {
            val collisionWith = collisionWith as Harmful
            return obvervable.setHealth(obvervable.getHealth() - collisionWith.getDamage())
        }
        return obvervable
    }
}
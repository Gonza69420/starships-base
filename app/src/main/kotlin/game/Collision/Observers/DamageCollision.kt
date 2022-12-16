package game.Collision.Observers

import game.Collision.Observer
import game.Constants.Constants
import game.Entities.Interfaces.Damageable
import game.Entities.Interfaces.Harmful
import game.Entities.Moveable

class DamageCollision(private val canCollisionWith : List<String>) : Observer<Damageable> {

    override fun update(collisionWith: Moveable, observable: Damageable) : Damageable {
        for (type in canCollisionWith) {
            if (collisionWith.getType().equals(type)) {
                //Modificar constante a generico
                return observable.setHealth( observable.getHealth() - Constants.ASTEROID_DAMAGE)
            }
        }
        return observable
    }
}
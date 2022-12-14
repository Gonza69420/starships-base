package game.Collision

import game.Entities.Moveable

interface Observer<T> {
    fun update(collisionWith : Moveable, obvervable : T) : T
}
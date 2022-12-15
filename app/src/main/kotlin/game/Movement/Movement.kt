package game.Movement

import game.Entities.Moveable

interface Movement {

    fun move(thingToMove : Moveable) : Moveable
}
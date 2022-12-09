package game.Entities.Asteroid.Strategy.Movement

import game.Position

class straightMovement : asteroidMovement {
    override fun move(): Position {
        return Position(0, 0)
    }
}
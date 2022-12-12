package game.Entities.Asteroid.Strategy.Movement

import game.Entities.Asteroid.Asteroid
import game.Entities.Moveable
import game.Position

interface asteroidMovement {

    fun move(asteroid: Asteroid) : Moveable
}
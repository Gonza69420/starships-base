package game.Entities.Asteroid.Strategy.Destroy

import game.Entities.Asteroid.Asteroid

interface DestroyStrategy<T> {
    fun destroy(asteroid : Asteroid) : List<T>
}
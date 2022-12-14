package game.Entities.Asteroid.Strategy.Destroy

import game.Entities.Asteroid.Asteroid

class destroyAsteroid : DestroyStrategy<Asteroid> {
    override fun destroy(asteroid: Asteroid): List<Asteroid> {
        return listOf()
    }
}

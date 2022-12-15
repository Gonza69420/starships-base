package game.Entities.Asteroid.Strategy.Destroy

import game.Entities.Asteroid.Asteroid
import game.Movement.straightMovement
import game.Position

class divideAsteroid(private val size : Int) : DestroyStrategy<Asteroid> {

    override fun destroy(asteroid: Asteroid): List<Asteroid> {
        val asteroids = mutableListOf<Asteroid>()
        for (i in 0 until size) {
            asteroids.add(Asteroid(asteroid.getHealth()/ size , asteroid.getSize()/ size, asteroid.getPosition(), asteroid.getFinalPosition(), asteroid.getPoints()/ size, destroyAsteroid(), straightMovement(0.0, asteroid.getVelocity(), asteroid.getPosition(), Position(asteroid.getFinalPosition().getX()*i , asteroid.getVelocityY()*i)), asteroid.getPosition(), asteroid.getVelocityX(), asteroid.getVelocityY(), asteroid.getId()))
        }
        return asteroids
    }
}

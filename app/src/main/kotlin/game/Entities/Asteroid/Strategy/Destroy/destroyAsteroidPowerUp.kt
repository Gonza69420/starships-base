package game.Entities.Asteroid.Strategy.Destroy

import game.Collision.Observers.PowerUpCollision
import game.Entities.Asteroid.Asteroid
import game.Entities.Gun.Gun
import game.Entities.PowerUp
import game.Movement.straightMovement
import game.Constants.Constants.Companion.POWERUP_ACCELERATION
import game.Constants.Constants.Companion.POWERUP_SPEED
import game.Constants.Constants.Companion.HEIGHT

import game.Position


class destroyAsteroidPowerUp(private val gun : Gun, private val id : Int) : DestroyStrategy<PowerUp> {

    override fun destroy(asteroid: Asteroid): List<PowerUp> {
        return listOf(PowerUp(gun,  asteroid.getPosition(),  POWERUP_SPEED, id, listOf(PowerUpCollision())))
    }
}
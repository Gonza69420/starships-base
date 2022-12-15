package game.Entities.Asteroid.Strategy.Destroy

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
        return listOf(PowerUp(gun, straightMovement(POWERUP_ACCELERATION, POWERUP_SPEED, asteroid.getPosition(), Position(asteroid.getPosition().getX(), HEIGHT )), asteroid.getPosition(), 0.0, POWERUP_SPEED, id))
    }
}
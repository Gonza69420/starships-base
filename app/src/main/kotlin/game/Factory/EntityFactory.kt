package game.Factory


import game.Constants.Constants.Companion.ASTEROID_HEALTH_MAX
import game.Constants.Constants.Companion.ASTEROID_HEALTH_MIN
import game.Constants.Constants.Companion.ASTEROID_POINTS
import game.Constants.Constants.Companion.ASTEROID_SIZE_MAX
import game.Constants.Constants.Companion.ASTEROID_SIZE_MIN
import game.Constants.Constants.Companion.ASTEROID_SPEED_MAX
import game.Constants.Constants.Companion.ASTEROID_SPEED_MIN
import game.Constants.Constants.Companion.BOMB_AMMO
import game.Constants.Constants.Companion.BOMB_SPEED
import game.Constants.Constants.Companion.HEIGHT
import game.Constants.Constants.Companion.LASER_AMMO
import game.Constants.Constants.Companion.MULTISHOOT_AMMO
import game.Constants.Constants.Companion.SHIP_HEALTH_EASY
import game.Constants.Constants.Companion.SHIP_HEALTH_Hard
import game.Constants.Constants.Companion.SHIP_HEALTH_Medium
import game.Constants.Constants.Companion.WIDTH
import game.Entities.Asteroid.Asteroid
import game.Entities.Asteroid.Strategy.Destroy.destroyAsteroid
import game.Entities.Asteroid.Strategy.Destroy.destroyAsteroidPowerUp
import game.Entities.Asteroid.Strategy.Destroy.divideAsteroid
import game.Entities.Bullet
import game.Entities.Gun.Laser
import game.Entities.Gun.MegaBomb
import game.Entities.Gun.normalGun
import game.Entities.Ship
import game.Movement.straightMovement
import game.Position

class EntityFactory {

    fun createShip(difficulty : String) : Ship {
        if (difficulty.equals("easy")){
            return Ship(normalGun(1, 100, 1), SHIP_HEALTH_EASY, Position(500.0, 500.0, 0.0), 0.0, 0.0, 0)
        } else if (difficulty.equals("medium")){
            return Ship(normalGun(1, 100, 1), SHIP_HEALTH_Medium, Position(500.0, 500.0, 0.0), 0.0, 0.0, 0)
        } else if (difficulty.equals("hard")){
            return Ship(normalGun(1, 100, 1), SHIP_HEALTH_Hard, Position(500.0, 500.0, 0.0), 0.0, 0.0, 0)
        }
        return Ship(normalGun(1, 100, 1), SHIP_HEALTH_Medium, Position(500.0, 500.0, 0.0), 0.0, 0.0, 0)
    }

    fun createBullet(ship: Ship, id : Int) : List<Bullet> {
        return ship.shoot(id)
    }

    fun  createAsteroid(id : Int, random : Double, random2 : Double, random3 : Double, random4 : Double) : Asteroid{
        val initialPositionTopDown = Position((WIDTH - 0.1 * random3) + 0.1, 0.0)
        val finalPositionTopDown = Position((WIDTH - 0.1 * random4) + 0.1, HEIGHT)
        val initialPositionLeftRight = Position(0.0, (HEIGHT - 0.1 * random3) + 0.1)
        val finalPositionLeftRight = Position(WIDTH, (HEIGHT - 0.1 * random4) + 0.1)
        if (random < 0.2 ) {
            if (random < 0.05) {
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroidPowerUp(normalGun(id+1, MULTISHOOT_AMMO, 3 ), id+2), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionTopDown, finalPositionTopDown), initialPositionTopDown, 0.0, 0.0, id)
            }else if (random < 0.1){
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroidPowerUp(normalGun(id+1, MULTISHOOT_AMMO, 3 ), id+2), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionLeftRight, finalPositionLeftRight), initialPositionLeftRight, 0.0, 0.0, id)
        }else if (random < 0.14){
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroidPowerUp(Laser(id+1, LASER_AMMO ), id+2), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionTopDown, Position((WIDTH - 0.1 * random2) + 0.1, HEIGHT)), initialPositionTopDown, 0.0, 0.0, id)
            }else if (random < 0.18) {
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroidPowerUp(Laser(id+1, LASER_AMMO ), id+2), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionLeftRight, finalPositionLeftRight), finalPositionLeftRight, 0.0, 0.0, id)
            }else if (random < 0.2){
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroidPowerUp(MegaBomb(
                    BOMB_AMMO, WIDTH, HEIGHT, id+1 ), id+2), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionTopDown, finalPositionTopDown), initialPositionTopDown, 0.0, 0.0, id)
            }
        } else if (random < 0.4){
            if (random < 0.2){
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, divideAsteroid(3), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionTopDown, finalPositionTopDown), initialPositionTopDown, 0.0, 0.0, id)
            }else{
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, divideAsteroid(3), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionLeftRight, finalPositionLeftRight), initialPositionLeftRight, 0.0, 0.0, id)
            }
        }else{
            if (random < 0.7){
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroid(), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionTopDown, finalPositionTopDown), initialPositionTopDown, 0.0, 0.0, id)
            }else{
                return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroid(), straightMovement(0.2,
                    (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionLeftRight, finalPositionLeftRight), initialPositionLeftRight, 0.0, 0.0, id)
            }
        }
        return Asteroid((ASTEROID_HEALTH_MAX - ASTEROID_HEALTH_MIN * random4) + ASTEROID_HEALTH_MIN,  (ASTEROID_SIZE_MAX - ASTEROID_SIZE_MIN) * random4 + ASTEROID_SIZE_MIN, ASTEROID_POINTS, destroyAsteroid(), straightMovement(0.2,
            (ASTEROID_SPEED_MAX - ASTEROID_SPEED_MIN) * random2 + ASTEROID_SPEED_MIN, initialPositionTopDown, finalPositionTopDown), initialPositionTopDown, 0.0, 0.0, id)
    }
}
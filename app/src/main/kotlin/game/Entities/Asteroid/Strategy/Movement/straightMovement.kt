package game.Entities.Asteroid.Strategy.Movement

import game.Entities.Asteroid.Asteroid
import game.Entities.Moveable
import game.Position

class straightMovement(val acceleration : Double, val initialVelocity : Double) : Movement {

    override fun move(asteroid: Moveable): Moveable {
        return if (asteroid.getVelocityX() == 0.0 && asteroid.getVelocityY() == 0.0) {
            if (asteroid.getInitialPosition().getX() == 0.0 || asteroid.getFinalPosition().getX() == 0.0){
                return Asteroid(asteroid.getPosition(), getInitialVelocityX( asteroid , true), getInitialVelocityY(asteroid, true), asteroid.getId())
            }
                return Asteroid(asteroid.getPosition(), getInitialVelocityX( asteroid, false ), getInitialVelocityY(asteroid,false), asteroid.getId())
        }else{
            accelerate(asteroid)
        }
    }


    fun accelerate(asteroid: Asteroid) : Moveable {
        return Asteroid(asteroid.getPosition(), asteroid.getVelocityX() * acceleration, asteroid.getVelocityY() * acceleration, asteroid.getId())
    }

    fun getAngleTopDown(asteroid: Asteroid) : Double {
        val getSide = Math.abs(asteroid.getInitialPosition().getX() - asteroid.getFinalPosition().getX())
        val getOpposite = Math.abs(asteroid.getInitialPosition().getY() - asteroid.getFinalPosition().getY())

        return Math.atan(getSide / getOpposite)
    }

    fun getAngleLeftRight(asteroid: Asteroid) : Double {
        val getSide = Math.abs(asteroid.getInitialPosition().getY() - asteroid.getFinalPosition().getY())
        val getOpposite = Math.abs(asteroid.getInitialPosition().getX() - asteroid.getFinalPosition().getX())

        return Math.atan(getSide / getOpposite)
    }

    fun getInitialVelocityX(asteroid: Asteroid, topDown : Boolean) : Double {
        return if (topDown) {
            initialVelocity * Math.sin(getAngleTopDown(asteroid))
        } else {
            initialVelocity * Math.cos(getAngleLeftRight(asteroid))
        }
    }

    fun getInitialVelocityY(asteroid: Asteroid, topDown: Boolean) : Double {
        return if (topDown) {
            initialVelocity * Math.cos(getAngleTopDown(asteroid))
        } else {
            initialVelocity * Math.sin(getAngleLeftRight(asteroid))
        }
    }

    fun getAceleration() : Double {
        return acceleration
    }


}
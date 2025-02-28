package game.Constants

class Constants {

    companion object {
        const val WIDTH: Double = 1000.0
        const val HEIGHT: Double = 1000.0
        const val SHIP_SPEED: Double = 5.0
        const val SHIP_ROTATION_SPEED: Double = 0.2
        const val BULLET_SPEED: Double = 10.0
        const val BULLET_DAMAGE: Double = 100.0
        const val BULLET_SIZEX: Double = 20.0
        const val BULLET_SIZEY: Double = 30.0
        const val MULTISHOOT_AMMO : Int = 15
        const val LASER_SIZEX: Double = 10.0
        const val LASER_SIZEY: Double = 80.0
        const val LASER_DAMAGE: Double = 150.0
        const val LASER_SPEED: Double = 50.0
        const val LASER_AMMO: Int = 10
        const val BOMB_DAMAGE: Double = 500.0
        const val BOMB_SIZEX: Double = WIDTH
        const val BOMB_SIZEY: Double = HEIGHT
        const val BOMB_SPEED: Double = 0.0
        const val BOMB_AMMO: Int = 1
        const val SHIP_SIZE: Int = 40
        const val SHIP_HEALTH_EASY: Double = 1000.0
        const val SHIP_HEALTH_Medium: Double = 300.0
        const val SHIP_HEALTH_Hard: Double = 100.0
        const val ASTEROID_SIZE_MIN: Double = 70.0
        const val ASTEROID_SIZE_MAX: Double = 250.0
        const val ASTEROID_HEALTH_MIN: Double = 200.0
        const val ASTEROID_HEALTH_MAX: Double = 1000.0
        const val ASTEROID_POINTS : Int = 100
        const val ASTEROID_DAMAGE: Double = 100.0
        const val ASTEROID_SPEED_MIN: Double = 0.5
        const val ASTEROID_SPEED_MAX: Double = 4.0
        const val POWERUP_SIZE: Int = 14
        const val POWERUP_SPEED: Double = 5.0
        const val POWERUP_ACCELERATION : Double = 0.0
        const val MAXASTEROIDS : Int = 10
        const val MAXENTITIES : Int = 20
        const val SPAWNASTEROIDCHANCE : Double = 0.05

        const val PLAYER1_ACCELERATE : String = "W"
        const val PLAYER1_ROTATE_LEFT : String = "A"
        const val PLAYER1_ROTATE_RIGHT : String = "D"
        const val PLAYER1_SHOOT : String = "SPACE"
        const val PLAYER1_REVERSE : String = "S"

        const val PLAYER2_ACCELERATE : String = "I"
        const val PLAYER2_ROTATE_LEFT : String = "J"
        const val PLAYER2_ROTATE_RIGHT : String = "L"
        const val PLAYER2_SHOOT : String = "O"
        const val PLAYER2_REVERSE : String = "K"

        const val PAUSEBUTTON : String = "P"
    }
}
package game.Entities.Interfaces

interface Damageable {
    fun getHealth() : Double
    fun setHealth(health : Double) : Damageable
    fun getPoints() : Int
}
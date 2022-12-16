package game.Entities.Interfaces

import game.Entities.Moveable

interface Damageable  {
    fun getHealth() : Double
    fun setHealth(health : Double) : Damageable
    fun getPoints() : Int
    fun isAlive() : Boolean
}
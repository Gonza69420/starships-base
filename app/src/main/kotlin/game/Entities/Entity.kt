package game.Entities

import game.Position

abstract class Entity(private val id : Int) {

    fun getId() : Int {
        return id
    }

}
package game.Entities

import game.Position

open class Entity(private val id : Int, private val type : String) {

    fun getId() : Int {
        return id
    }

    fun getType() : String {
        return type
    }
}
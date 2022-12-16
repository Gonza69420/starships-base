package game.Collision

import game.Entities.Moveable

interface Observable  {

    fun registerObserver(observer: Observer<*>) : Moveable
    fun removeObserver(observer: Observer<*>) : Moveable
    fun notifyObservers(collisionWith : Moveable) : Moveable
    fun getObservers() : List<Observer<*>>
}
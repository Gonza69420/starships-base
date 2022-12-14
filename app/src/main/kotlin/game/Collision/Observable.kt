package game.Collision

interface Observable {

    fun registerObserver(observer: Observer<*>)
    fun removeObserver(observer: Observer<*>)
    fun notifyObservers()
}
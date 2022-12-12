package game.Adapter

import edu.austral.ingsis.starships.ui.ElementModel

interface Adapter<T> {
    fun adapt(t: T): ElementModel
}
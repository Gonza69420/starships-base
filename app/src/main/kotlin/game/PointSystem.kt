package game

class PointSystem(private val Points : Int) {

        fun getPoints() : Int {
            return Points
        }

        fun addPoints(points : Int) : PointSystem {
            return PointSystem(Points + points)
        }

        fun removePoints(points : Int) : PointSystem {
            return PointSystem(Points - points)
        }
    
}
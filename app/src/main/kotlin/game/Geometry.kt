package game

class Geometry {

    fun fromInitialPointGetFinalPoint(initialPoint: Position): Position {
        val screenSize = 1000
        val angle = initialPoint.getAngleFromRadians()
        val distance : Double = screenSize - initialPoint.getX()
        val x = initialPoint.getX() + distance * Math.cos(angle)
        val y = initialPoint.getY() + distance * Math.sin(angle)
        return Position(x, y)
    }

}
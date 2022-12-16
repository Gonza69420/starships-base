package game

class Geometry {

    fun fromInitialPointGetFinalPoint(initialPoint: Position): Position {
        val screenSize = 1000
        val angle = initialPoint.getAngle()
        val distance : Double = screenSize - initialPoint.getX()
        val x = initialPoint.getX() + distance
        val y = initialPoint.getY() + distance
        return Position(x, y, angle )
    }

    open fun getRadianesFromAngle(angle : Double) : Double {
        return angle * Math.PI / 180
    }

    open fun getAngleFromRadians(radians : Double) : Double {
        return radians * 180 / Math.PI
    }

}
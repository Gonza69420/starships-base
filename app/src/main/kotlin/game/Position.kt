package game

class Position(private val x :  Double , private val  y : Double, private var radians : Double) {

    constructor( x : Double ,  y : Double) : this( x ,  y , 0.0) {
        val temp = Math.acos(x / Math.sqrt((x *  x  +  y *  y).toDouble()))
        radians = if ( temp > 2*Math.PI) temp - 2 * Math.PI else temp
    }

    fun getX() : Double {
        return x
    }

    fun getY() : Double {
        return y
    }

    fun getRadians() : Double {
        return radians
    }

    fun getAngleFromRadians() : Double {
        return getRadians() * 180 / Math.PI
    }
}
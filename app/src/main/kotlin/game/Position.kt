package game

class Position(private val x :  Double , private val  y : Double, private var angle : Double) {

    constructor( x : Double ,  y : Double) : this( x ,  y , 0.0) {
        val temp = Math.acos(x / Math.sqrt((x *  x  +  y *  y).toDouble()))
        angle = if ( temp > 2*Math.PI) temp - 2 * Math.PI else temp
    }

    fun getX() : Double {
        return x
    }

    fun getY() : Double {
        return y
    }

    fun getAngle() : Double {
        return angle
    }

    fun getRadianFromAngle() : Double {
        return angle * Math.PI / 180
    }
}
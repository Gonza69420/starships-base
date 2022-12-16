package game.Adapter

import edu.austral.ingsis.starships.ui.ElementColliderType
import edu.austral.ingsis.starships.ui.ElementModel
import edu.austral.ingsis.starships.ui.ImageRef
import game.Entities.Bullet
import game.Entities.Moveable
import game.Geometry

class BulletAdapater(private val sizeX: Double, private val sizeY : Double, private val type: String) : Adapter<Moveable> {
    val geometry = Geometry()
    override fun adapt(t: Moveable): ElementModel {
        return ElementModel(t.getId().toString(), t.getPosition().getX(), t.getPosition().getY(), sizeX, sizeY, geometry.getAngleFromRadians(t.getPosition().getAngle() ) + 270, ElementColliderType.Elliptical, ImageRef(type, sizeX, sizeY))
    }
}
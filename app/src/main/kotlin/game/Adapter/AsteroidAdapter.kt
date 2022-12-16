package game.Adapter

import edu.austral.ingsis.starships.ui.ElementColliderType
import edu.austral.ingsis.starships.ui.ElementModel
import edu.austral.ingsis.starships.ui.ImageRef
import game.Entities.Asteroid.Asteroid
import game.Entities.Moveable
import game.Geometry

class AsteroidAdapter(private val size : Double) : Adapter<Moveable>{
    val geometry = Geometry()

    override fun adapt(t: Moveable): ElementModel {
        return ElementModel(t.getId().toString(), t.getPosition().getX(), t.getPosition().getY(), size, size, geometry.getAngleFromRadians(t.getPosition().getAngle() ) + 270, ElementColliderType.Elliptical, ImageRef("asteroids", size, size))
    }
}
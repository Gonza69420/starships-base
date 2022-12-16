package game.Adapter

import edu.austral.ingsis.starships.ui.ElementColliderType
import edu.austral.ingsis.starships.ui.ElementModel
import edu.austral.ingsis.starships.ui.ImageRef
import game.Entities.Asteroid.Asteroid
import game.Geometry

class AsteroidAdapter : Adapter<Asteroid>{
    val geometry = Geometry()

    override fun adapt(t: Asteroid): ElementModel {
        return ElementModel(t.getId().toString(), t.getPosition().getX(), t.getPosition().getY(), t.getSize(), t.getSize(), geometry.getAngleFromRadians(t.getPosition().getAngle() ) + 270, ElementColliderType.Elliptical, ImageRef("asteroids", t.getSize(), t.getSize()))
    }
}
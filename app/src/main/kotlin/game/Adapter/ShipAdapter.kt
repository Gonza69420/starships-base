package game.Adapter

import edu.austral.ingsis.starships.ui.ElementColliderType
import edu.austral.ingsis.starships.ui.ElementModel
import edu.austral.ingsis.starships.ui.ImageRef
import game.Entities.Ship
import game.Geometry


class ShipAdapter : Adapter<Ship> {
    val geometry = Geometry()

    override fun adapt(t: Ship): ElementModel {
        return ElementModel(
            t.getId().toString(),
            t.getPosition().getX(),
            t.getPosition().getY(),
            40.0,
            40.0,
            geometry.getAngleFromRadians(t.getPosition().getAngle() ) + 270,
            ElementColliderType.Triangular,
            ImageRef("starship", 70.0, 70.0)
        )
    }

}
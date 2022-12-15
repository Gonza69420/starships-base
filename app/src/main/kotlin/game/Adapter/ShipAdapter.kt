package game.Adapter

import edu.austral.ingsis.starships.ui.ElementColliderType
import edu.austral.ingsis.starships.ui.ElementModel
import edu.austral.ingsis.starships.ui.ImageRef
import game.Entities.Gun.normalGun
import game.Entities.Ship
import game.Position


class ShipAdapter : Adapter<Ship> {
    override fun adapt(t: Ship): ElementModel {
        return ElementModel(
            t.getId().toString(),
            t.getPosition().getX(),
            t.getPosition().getY(),
            40.0,
            40.0,
            t.getPosition().getRadians(),
            ElementColliderType.Triangular,
            ImageRef("starship", 70.0, 70.0)

        )
    }

}
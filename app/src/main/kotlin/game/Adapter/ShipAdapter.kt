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
            t.getPosition().getRadians() + 270,
            ElementColliderType.Triangular,
            ImageRef("starship", 70.0, 70.0)

        )
    }

    fun invert(t: ElementModel) : Ship{
        return Ship( normalGun(2, 0 ,1) , Position(t.x.get(), t.y.get(), t.rotationInDegrees.get()), 2.0, 2.0, 1)
    }
}
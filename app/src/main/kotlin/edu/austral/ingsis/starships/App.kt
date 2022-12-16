package edu.austral.ingsis.starships

import edu.austral.ingsis.starships.ui.*
import edu.austral.ingsis.starships.ui.ElementColliderType.*
import game.Adapter.ShipAdapter
import game.Constants.Constants
import game.Entities.Gun.normalGun
import game.Entities.Ship
import game.Factory.EntityFactory
import game.Movement.ShipMovement
import game.Position
import game.gameState.Command.Commands.AccelerateCommand
import game.gameState.Command.Commands.DesacelerateCommand
import game.gameState.Command.Commands.RotateLeft
import game.gameState.Command.Commands.RotateRight
import game.gameState.Command.Invoker
import game.gameState.Game
import game.gameState.GamePlayeable
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.stage.Stage

fun main() {
    launch(Starships::class.java)
}

class Starships() : Application() {
    private val imageResolver = CachedImageResolver(DefaultImageResolver())
    private val facade = ElementsViewFacade(imageResolver)
    private val keyTracker = KeyTracker()

    companion object {
        val STARSHIP_IMAGE_REF = ImageRef("starship", 70.0, 70.0)
        val Invoker : Invoker = Invoker(listOf())
        var game : Game = GamePlayeable(Constants.WIDTH, Constants.HEIGHT, listOf(), listOf(), 0, 2, Invoker)
    }

    override fun start(primaryStage: Stage) {
        facade.elements["asteroid-1"] =
            ElementModel("asteroid-1", 0.0, 0.0, 30.0, 40.0, 0.0, Elliptical, null)
        facade.elements["asteroid-2"] =
            ElementModel("asteroid-2", 100.0, 100.0, 30.0, 20.0, 90.0, Rectangular, null)
        facade.elements["asteroid-3"] =
            ElementModel("asteroid-3", 200.0, 200.0, 20.0, 30.0, 180.0, Elliptical, null)

        Invoker.addCommand(AccelerateCommand("W" , 1))
        Invoker.addCommand(DesacelerateCommand("S" , 1))
        Invoker.addCommand(RotateLeft("A" , 1))
        Invoker.addCommand(RotateRight("D" , 1))

        game = game.setInvoker(Invoker)

        game = game.setShip(listOf(EntityFactory().createShip("easy")))


        facade.elements["starship"] = ShipAdapter().adapt(game.getShip().get(0))

        facade.timeListenable.addEventListener(TimeListener(facade.elements, facade))
        facade.collisionsListenable.addEventListener(CollisionListener())
        keyTracker.keyPressedListenable.addEventListener(KeyPressedListener())

        val scene = Scene(facade.view)
        keyTracker.scene = scene

        primaryStage.scene = scene
        primaryStage.height = 800.0
        primaryStage.width = 800.0

        facade.start()
        keyTracker.start()
        primaryStage.show()
    }

    override fun stop() {
        facade.stop()
        keyTracker.stop()
    }
}

class TimeListener(private val elements: Map<String, ElementModel>, private var facade: ElementsViewFacade) : EventListener<TimePassed> {
    override fun handle(event: TimePassed) {
        val game = Starships.game.moveEntities()
        val gameObjects = game.getShip()

        for (gameObject in gameObjects){
            if (gameObject is Ship){
                facade.elements["starship"] = ShipAdapter().adapt(gameObject)
            }
        }
        elements.forEach { facade.elements[it.key] = it.value }
    }
}

class CollisionListener() : EventListener<Collision> {
    override fun handle(event: Collision) {
        println("${event.element1Id} ${event.element2Id}")
    }

}

class KeyPressedListener(): EventListener<KeyPressed> {
    override fun handle(event: KeyPressed) {
        val movement = ShipMovement()
        when(event.key) {
            KeyCode.W -> {
                Starships.game = Starships.game.handleAction("W")
            }
            KeyCode.S -> {
                Starships.game = Starships.game.handleAction("S")
            }
            KeyCode.A -> {
                Starships.game = Starships.game.handleAction("A")
            }
            KeyCode.D -> {
                Starships.game = Starships.game.handleAction("D")
            }
            else -> {}
        }
    }

}
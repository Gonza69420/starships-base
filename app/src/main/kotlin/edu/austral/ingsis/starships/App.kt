package edu.austral.ingsis.starships

import edu.austral.ingsis.starships.ui.*
import edu.austral.ingsis.starships.ui.ElementColliderType.*
import game.Adapter.AsteroidAdapter
import game.Adapter.BulletAdapater
import game.Adapter.ShipAdapter
import game.Constants.Constants
import game.Entities.Asteroid.Asteroid
import game.Entities.Gun.normalGun
import game.Entities.Moveable

import game.Entities.Ship
import game.Factory.EntityFactory
import game.Movement.ShipMovement
import game.Position
import game.gameState.Command.Commands.*
import game.gameState.Command.Invoker
import game.gameState.Game
import game.gameState.GamePlayeable
import javafx.application.Application
import javafx.application.Application.launch
import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.Scene
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color.PURPLE
import javafx.stage.Stage

fun main() {
    launch(Starships::class.java)
}

class Starships() : Application() {
    private val imageResolver = CachedImageResolver(DefaultImageResolver())
    private val facade = ElementsViewFacade(imageResolver)
    private val keyTracker = KeyTracker()

    companion object {
        val Invoker: Invoker = Invoker(listOf())
        var game: Game = GamePlayeable(Constants.WIDTH, Constants.HEIGHT, listOf(), listOf(), 0, 2, Invoker)
        val entityFactory: EntityFactory = EntityFactory()
    }

    override fun start(primaryStage: Stage) {
        Invoker.addCommand(AccelerateCommand(Constants.PLAYER1_ACCELERATE, 1))
        Invoker.addCommand(DesacelerateCommand(Constants.PLAYER1_REVERSE, 1))
        Invoker.addCommand(RotateLeft(Constants.PLAYER1_ROTATE_LEFT, 1))
        Invoker.addCommand(RotateRight(Constants.PLAYER1_ROTATE_RIGHT, 1))
        Invoker.addCommand(ShootCommand(Constants.PLAYER1_SHOOT, 1))
        Invoker.addCommand(PauseGameCommand(Constants.PAUSEBUTTON))


        Invoker.addCommand(AccelerateCommand(Constants.PLAYER2_ACCELERATE, 2))
        Invoker.addCommand(DesacelerateCommand( Constants.PLAYER2_REVERSE, 2))
        Invoker.addCommand(RotateLeft(Constants.PLAYER2_ROTATE_LEFT, 2))
        Invoker.addCommand(RotateRight(Constants.PLAYER2_ROTATE_RIGHT, 2))
        Invoker.addCommand(ShootCommand(Constants.PLAYER2_SHOOT, 2))



        game = game.setInvoker(Invoker)

        game = game.setShip(listOf(EntityFactory().createShip("easy", 0), EntityFactory().createShip("easy", 2)))


        facade.elements["0"] = ShipAdapter().adapt(game.getShip().get(0))
        facade.elements["2"] = ShipAdapter().adapt(game.getShip().get(1))

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

        var gameObjects : MutableList<Moveable> = mutableListOf()
        for (entity in Starships.game.getShip()) {
            if (!entity.isAlive()){
                System.exit(0)
            }
            gameObjects.add(entity)
        }

        if (Math.random() < Constants.SPAWNASTEROIDCHANCE){
            Starships.game = Starships.game.generateEntity(
                Starships.entityFactory.createAsteroid(
                    Starships.game.gameGetEntityNumber(),
                    Math.random(),
                    Math.random(),
                    Math.random(),
                    Math.random()
                )
            )
        }

        for (entity in Starships.game.getEntities()) {
            gameObjects.add(entity)
        }
        for (gameObject in gameObjects){
            if (gameObject is Ship){
                facade.elements[gameObject.getId().toString()] = ShipAdapter().adapt(gameObject)
            }
            if (gameObject.getType().equals("Asteroid")){
                facade.elements[gameObject.getId().toString()] = AsteroidAdapter(gameObject.getSize()).adapt(gameObject)
                if (gameObject.isOutOfBounds(Constants.WIDTH, Constants.HEIGHT)){
                    facade.elements[gameObject.getId().toString()] = null
                }
            }
            if (gameObject.getType().equals("normalBullet")){
                facade.elements[gameObject.getId().toString()] = BulletAdapater(Constants.BULLET_SIZEX, Constants.BULLET_SIZEY, gameObject.getType()).adapt(gameObject)
                if (gameObject.isOutOfBounds(Constants.WIDTH, Constants.HEIGHT)){
                    facade.elements[gameObject.getId().toString()] = null
                }
            }

            if(gameObject.getType().equals("Laser")){
                facade.elements[gameObject.getId().toString()] = BulletAdapater(Constants.LASER_SIZEX, Constants.LASER_SIZEY, gameObject.getType()).adapt(gameObject)
                if (gameObject.isOutOfBounds(Constants.WIDTH, Constants.HEIGHT)){
                    facade.elements[gameObject.getId().toString()] = null
                }
            }
        }

        Starships.game = Starships.game.moveEntities()

        elements.forEach { facade.elements[it.key] = it.value }
    }
}

class CollisionListener() : EventListener<Collision> {
    override fun handle(event: Collision) {
        Starships.game = Starships.game.handleCollision(Starships.game.getEntityFromId(event.element1Id.toInt()), Starships.game.getEntityFromId(event.element2Id.toInt()))
    }

}

class KeyPressedListener(): EventListener<KeyPressed> {
    override fun handle(event: KeyPressed) {
        val movement = ShipMovement()
       // when(event.key) {
            Starships.game = Starships.game.handleAction(event.key.toString())
            /*KeyCode.W -> {
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
            KeyCode.SPACE -> {
                Starships.game = Starships.game.handleAction("SPACE")
            }
            KeyCode.I -> {
                Starships.game = Starships.game.handleAction("I")
            }
            KeyCode.K -> {
                Starships.game = Starships.game.handleAction("K")
            }
            KeyCode.J -> {
                Starships.game = Starships.game.handleAction("J")
            }
            KeyCode.L -> {
                Starships.game = Starships.game.handleAction("L")
            }
            KeyCode.O -> {
                Starships.game = Starships.game.handleAction("O")
            }
            KeyCode.P -> {

            }

             */
           // else -> {}
        //}
    }

}
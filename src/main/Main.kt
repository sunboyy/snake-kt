package main

import controller.GameController
import controller.KeyboardController
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.KeyEvent
import javafx.scene.layout.HBox
import javafx.stage.Stage
import view.GameCanvas

class Main: Application() {
    override fun start(primaryStage: Stage?) {
        val canvas = GameCanvas()
        val layout = HBox(canvas)
        val scene = Scene(layout)
        scene.onKeyPressed = EventHandler<KeyEvent> { event ->
            KeyboardController.instance.addKey(event.code)
        }
        primaryStage!!.title = "Snake AI"
        primaryStage.scene = scene
        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}

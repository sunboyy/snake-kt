package view

import controller.GameController
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.canvas.Canvas
import javafx.util.Duration
import constant.Constant

class GameCanvas : Canvas(Constant.windowWidth, Constant.windowHeight) {

    private val timeline: Timeline

    private val gameField = GameFieldUI(GameController.instance)
    private val statusBar = StatusBarUI(GameController.instance)

    init {
        val kf = KeyFrame(Duration.seconds(1.0/60), EventHandler<ActionEvent> {
            GameController.instance.update()
            render()
        })
        timeline = Timeline(kf)
        timeline.cycleCount = Timeline.INDEFINITE
        timeline.play()
    }

    private fun render() {
        graphicsContext2D.translate(0.0, Constant.statusBarHeight)
        gameField.render(graphicsContext2D)
        graphicsContext2D.translate(0.0, -Constant.statusBarHeight)

        statusBar.render(graphicsContext2D)
    }

}
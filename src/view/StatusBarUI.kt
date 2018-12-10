package view

import controller.GameController
import javafx.geometry.VPos
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.TextAlignment
import constant.Constant

class StatusBarUI(private val gameController: GameController) {

    private val scoreLeftMargin = 10.0

    fun render(gc: GraphicsContext) {
        gc.fill = Color.WHITE
        gc.fillRect(0.0, 0.0, Constant.gameViewWidth, Constant.statusBarHeight)
        gc.fill = Color.BLACK
        gc.textAlign = TextAlignment.LEFT
        gc.textBaseline = VPos.CENTER
        gc.font = Font.font("Helvetica", 14.0)
        gc.fillText("Score: " + gameController.score(), scoreLeftMargin, Constant.statusBarHeight / 2)
    }

}
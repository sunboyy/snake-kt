package view

import controller.GameController
import controller.GameState
import javafx.geometry.VPos
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.TextAlignment
import constant.Constant

class GameFieldUI(private val gameController: GameController) {
    fun render(gc: GraphicsContext) {
        gameController.map.render(gc)
        gameController.snake.render(gc)
        gameController.food.render(gc)
        when {
            gameController.state == GameState.READY -> renderReady(gc)
            gameController.state == GameState.PAUSED -> renderPaused(gc)
            gameController.state == GameState.END -> renderGameEnded(gc)
        }
    }

    private fun renderReady(gc: GraphicsContext) {
        gc.fill = Color.color(0.0, 0.0, 0.0, 0.6)
        gc.fillRect(0.0, 0.0, Constant.gameViewWidth, Constant.gameViewHeight)
        gc.textAlign = TextAlignment.CENTER
        gc.textBaseline = VPos.BOTTOM
        gc.fill = Color.WHITE
        gc.font = Font.font("Helvetica", 36.0)
        gc.fillText("Ready", Constant.gameViewWidth / 2, Constant.gameViewHeight / 2)
        gc.textBaseline = VPos.TOP
        gc.font = Font.font("Helvetica", 14.0)
        gc.fillText("Press SPACE to start",
                Constant.gameViewWidth/ 2, Constant.gameViewHeight / 2 + 12)
    }

    private fun renderPaused(gc: GraphicsContext) {
        gc.fill = Color.color(0.0, 0.0, 0.0, 0.6)
        gc.fillRect(0.0, 0.0, Constant.gameViewWidth, Constant.gameViewHeight)
        gc.textAlign = TextAlignment.CENTER
        gc.textBaseline = VPos.BOTTOM
        gc.fill = Color.WHITE
        gc.font = Font.font("Helvetica", 36.0)
        gc.fillText("Paused", Constant.gameViewWidth / 2, Constant.gameViewHeight / 2)
        gc.textBaseline = VPos.TOP
        gc.font = Font.font("Helvetica", 14.0)
        gc.fillText("Press SPACE again to continue",
                Constant.gameViewWidth/ 2, Constant.gameViewHeight / 2 + 12)
    }

    private fun renderGameEnded(gc: GraphicsContext) {
        gc.fill = Color.color(0.0, 0.0, 0.0, 0.6)
        gc.fillRect(0.0, 0.0, Constant.gameViewWidth, Constant.gameViewHeight)
        gc.textAlign = TextAlignment.CENTER
        gc.textBaseline = VPos.BOTTOM
        gc.fill = Color.WHITE
        gc.font = Font.font("Helvetica", 36.0)
        gc.fillText("Game Over", Constant.gameViewWidth / 2, Constant.gameViewHeight / 2)
        gc.textBaseline = VPos.TOP
        gc.font = Font.font("Helvetica", 14.0)
        gc.fillText("Score: " + gameController.score(),
                Constant.gameViewWidth/ 2, Constant.gameViewHeight / 2 + 12)
    }
}
package model

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import constant.Constant

class Obstacle(val position: Position) {

    fun render(gc: GraphicsContext) {
        gc.fill = Color.PURPLE
        gc.fillRect(position.x * Constant.blockSize, position.y * Constant.blockSize, Constant.blockSize, Constant.blockSize)
    }

}
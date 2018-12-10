package model

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import constant.Constant

class Map(val obstacles: List<Obstacle>) {
    /**
     * @param position The position to be checked
     * @return whether the specified position is contained in the obstacles list
     */
    fun collideObstacle(position: Position): Boolean {
        return obstacles.map { it.position }.contains(position)
    }

    fun render(gc: GraphicsContext) {
        for (i: Int in 0 until Constant.mapSize) {
            for (j: Int in 0 until Constant.mapSize) {
                gc.fill = if ((i + j) % 2 == 0) Color.ANTIQUEWHITE else Color.WHITE
                gc.fillRect(j * Constant.blockSize, i * Constant.blockSize, Constant.blockSize, Constant.blockSize)
            }
        }
        obstacles.forEach { it.render(gc) }
    }
}
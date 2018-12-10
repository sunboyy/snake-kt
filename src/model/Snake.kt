package model

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import constant.Constant
import java.util.*

class Snake {

    val body: MutableList<Position> = LinkedList()
    var direction = Direction.RIGHT
        private set
    var nextDirection = Direction.RIGHT
        private set

    val head: Position
        get() = body.last()

    val length: Int
        get() = body.size

    init {
        val center = Constant.mapSize / 2
        for (i: Int in 0 until Constant.initialLength) {
            body.add(0, Position(center-i, center))
        }
    }

    /**
     * Returns the snake's next head position
     */
    fun nextPosition(): Position {
        return when (nextDirection) {
            Direction.LEFT -> head.left
            Direction.RIGHT -> head.right
            Direction.UP -> head.top
            else -> head.bottom
        }
    }

    /**
     * Changes direction of a snake. The new direction has to be angled 90 degrees with the current direction.
     *
     * @param direction A new direction
     */
    fun changeDirection(direction: Int) {
        if (Direction.rightAngle(direction, this.direction)) {
            nextDirection = direction
        }
    }

    /**
     * Moves a snake one step
     *
     * @param lengthen The snake's tail will be retained if this value is true
     */
    fun move(lengthen: Boolean = false) {
        direction = nextDirection
        body.add(nextPosition())
        if (!lengthen) {
            body.removeAt(0)
        }
    }

    fun render(gc: GraphicsContext) {
        for (block: Position in body) {
            gc.fill = if (block == head) Color.BLACK else Color.BLUE
            gc.fillRect(block.x * Constant.blockSize, block.y * Constant.blockSize, Constant.blockSize, Constant.blockSize)
        }
    }

}
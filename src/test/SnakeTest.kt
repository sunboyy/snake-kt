package test

import model.Direction
import model.Snake
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SnakeTest {

    @Test
    fun changeDirection() {
        val snake = Snake()
        snake.changeDirection(Direction.RIGHT)
        snake.changeDirection(Direction.UP)
        assertEquals(Direction.UP, snake.nextDirection)
        snake.changeDirection(Direction.DOWN)
        assertEquals(Direction.DOWN, snake.nextDirection)
        snake.changeDirection(Direction.LEFT)
        assertEquals(Direction.DOWN, snake.nextDirection)
        snake.move()
        snake.changeDirection(Direction.UP)
        assertEquals(Direction.DOWN, snake.nextDirection)
        snake.changeDirection(Direction.LEFT)
        assertEquals(Direction.LEFT, snake.nextDirection)
        snake.changeDirection(Direction.RIGHT)
        assertEquals(Direction.RIGHT, snake.nextDirection)
    }

    @Test
    fun testMove() {
        val snake = Snake()
        val position = snake.head
        snake.changeDirection(Direction.RIGHT)
        snake.move()
        snake.move()
        assertEquals(position.right.right, snake.head)

        snake.changeDirection(Direction.UP)
        snake.move()
        assertEquals(position.right.right.top, snake.head)

        snake.changeDirection(Direction.LEFT)
        snake.move()
        assertEquals(position.right.top, snake.head)

        snake.changeDirection(Direction.DOWN)
        snake.move()
        snake.move()
        assertEquals(position.right.bottom, snake.head)

        val length = snake.length
        snake.move(true)
        snake.move(true)
        assertEquals(length + 2, snake.length)
    }

    @Test
    fun testNextDirection() {
        val snake = Snake()
        val position = snake.head
        snake.changeDirection(Direction.RIGHT)
        assertEquals(position.right, snake.nextPosition())

        snake.move()
        snake.changeDirection(Direction.UP)
        assertEquals(position.right.top, snake.nextPosition())

        snake.move()
        snake.changeDirection(Direction.LEFT)
        assertEquals(position.top, snake.nextPosition())

        snake.move()
        snake.changeDirection(Direction.DOWN)
        assertEquals(position, snake.nextPosition())
    }

}
package controller

import javafx.scene.input.KeyCode
import constant.Constant
import model.*
import model.Map

class GameController {

    val map: Map
    lateinit var snake: Snake
    lateinit var food: Food
    lateinit var state: GameState

    private var snakeMoveTick = 0

    init {
        val obstacles = (0 until Constant.mapSize).map { Obstacle(Position(it, 0)) }.toMutableList()
        obstacles.addAll((0 until Constant.mapSize).map { Obstacle(Position(it, Constant.mapSize - 1)) })
//        obstacles.addAll((1 until (Constant.mapSize - 1)).map { Obstacle(Position(0, it)) })
//        obstacles.addAll((1 until (Constant.mapSize - 1)).map { Obstacle(Position(Constant.mapSize - 1, it)) })
        map = Map(obstacles)
        setup()
    }

    fun setup() {
        snake = Snake()
        food = generateFood()
        state = GameState.READY
    }

    private fun generateFood(): Food {
        val bannedPositions = map.obstacles.map { it.position }.toMutableList()
        bannedPositions.addAll(snake.body)
        return Food(Position.random(Constant.mapSize, Constant.mapSize, bannedPositions))
    }

    fun score(): Int {
        return snake.length - Constant.initialLength
    }

    fun update() {
        if (state != GameState.PLAY) return
        when (KeyboardController.instance.pollKey()) {
            KeyCode.LEFT -> GameController.instance.snake.changeDirection(Direction.LEFT)
            KeyCode.RIGHT -> GameController.instance.snake.changeDirection(Direction.RIGHT)
            KeyCode.UP -> GameController.instance.snake.changeDirection(Direction.UP)
            KeyCode.DOWN -> GameController.instance.snake.changeDirection(Direction.DOWN)
            else -> { }
        }
        snakeMoveTick = (snakeMoveTick + 1) % Constant.snakeMoveTick
        if (snakeMoveTick == 0) {
            val nextPosition = snake.nextPosition()
            if (nextPosition == food.position) {
                snake.move(true)
                food = generateFood()
            } else if (map.collideObstacle(nextPosition) || snake.body.contains(nextPosition)) {
                state = GameState.END
            } else {
                snake.move()
            }
        }
    }

    fun togglePause() {
        when (state) {
            GameState.READY -> state = GameState.PLAY
            GameState.PAUSED -> state = GameState.PLAY
            GameState.PLAY -> state = GameState.PAUSED
            else -> setup()
        }
    }

    companion object {
        var instance = GameController()
            private set
    }
}
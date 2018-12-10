package model

import constant.Constant

class Position(var x: Int, var y: Int) {

    override fun equals(other: Any?): Boolean {
        if (other is Position) {
            return x == other.x && y == other.y
        }
        return false
    }

    val left: Position
        get() = Position((x + Constant.mapSize - 1) % Constant.mapSize, y)

    val right: Position
        get() = Position((x + 1) % Constant.mapSize, y)

    val top: Position
        get() = Position(x, (y + Constant.mapSize - 1) % Constant.mapSize)

    val bottom: Position
        get() = Position(x, (y + 1) % Constant.mapSize)

    companion object {
        /**
         * Returns random position for the specified constraints
         *
         * @param maxX The x-value in the return value will be less than this value
         * @param maxY The y-value in the return value will be less than this value
         * @param bannedPositions The return value cannot be in this list
         */
        fun random(maxX: Int, maxY: Int, bannedPositions: List<Position> = emptyList()): Position {
            while (true) {
                val x = Math.floor(Math.random() * maxX).toInt()
                val y = Math.floor(Math.random() * maxY).toInt()
                val position = Position(x, y)
                if (!bannedPositions.contains(position)) {
                    return position
                }
            }
        }
    }

}
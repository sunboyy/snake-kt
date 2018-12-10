package model

class Direction private constructor() {
    companion object {
        const val UP = 0
        const val RIGHT = 1
        const val DOWN = 2
        const val LEFT = 3

        /**
         * Returns angle between two directions
         * @param direction1 First direction
         * @param direction2 Second direction
         * @return number represent angle
         * 0: 0 degree
         * 1: 90 degrees
         * 2: 180 degrees
         * 3: 270 degrees
         */
        fun angle(direction1: Int, direction2: Int): Int {
            return (direction1 - direction2 + 4) % 4
        }

        /**
         * @param direction1 First direction
         * @param direction2 Second direction
         * @return whether two directions create right angle
         */
        fun rightAngle(direction1: Int, direction2: Int): Boolean {
            return Math.abs(angle(direction1, direction2)) % 2 == 1
        }
    }
}
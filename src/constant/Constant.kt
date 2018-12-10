package constant

class Constant {
    companion object {
        const val blockSize = 10.0
        const val mapSize = 30
        const val initialLength = 4
        const val snakeMoveTick = 6
        const val statusBarHeight = 40.0

        val gameViewWidth: Double
            get() = mapSize * blockSize
        val gameViewHeight: Double
            get() = gameViewWidth
        val windowWidth: Double
            get() = gameViewWidth
        val windowHeight: Double
            get() = gameViewHeight + statusBarHeight
    }
}
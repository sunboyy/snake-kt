package test

import model.Map
import model.Obstacle
import model.Position
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MapTest {

    private val map = Map(Arrays.asList(
            Obstacle(Position(0, 0)),
            Obstacle(Position(1, 0)),
            Obstacle(Position(2, 0)),
            Obstacle(Position(0, 1)),
            Obstacle(Position(0, 2))))

    @Test
    fun testCollideObstacle() {
        val position1 = Position(2, 2)
        val position2 = Position(0, 1)
        assertFalse(map.collideObstacle(position1))
        assertTrue(map.collideObstacle(position2))
    }

}
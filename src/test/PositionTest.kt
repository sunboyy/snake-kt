package test

import model.Position
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class PositionTest {

    @Test
    fun testEquals() {
        val position1: Any? = Position(3, 4)
        val position2: Any? = Position(3, 4)
        val position3: Any? = Position(3, 5)
        val position4: Any? = 3
        assertEquals(position1, position2)
        assertNotEquals(position1, position3)
        assertNotEquals(position1, position4)
        assertNotEquals(position4, position1)
        assertNotEquals(position1, null)
    }

    @Test
    fun testMovePosition() {
        val position = Position(5, 2)
        assertEquals(position.left, Position(4, 2))
        assertEquals(position.right, Position(6, 2))
        assertEquals(position.top, Position(5, 1))
        assertEquals(position.bottom, Position(5, 3))
    }

    @Test
    fun testRandomPosition() {
        for (i in 1..100) {
            val position = Position.random(20, 30)
            assertTrue(position.x >= 0, "X lower bound")
            assertTrue(position.x < 20, "X upper bound")
            assertTrue(position.y >= 0, "Y lower bound")
            assertTrue(position.y < 30, "Y upper bound")
        }
        val bannedPositions = Arrays.asList(Position(2, 5), Position(3, 4),
                Position(3, 7), Position(4, 1), Position(2, 3))
        for (i in 1..100) {
            val position = Position.random(5, 10, bannedPositions)
            assertFalse(bannedPositions.contains(position), "Banned position")
        }
    }

}
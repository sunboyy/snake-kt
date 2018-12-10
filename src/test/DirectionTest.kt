package test

import model.Direction
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DirectionTest {

    @Test
    fun testAngle() {
        assertEquals(0, Direction.angle(Direction.UP, Direction.UP))
        assertEquals(3, Direction.angle(Direction.UP, Direction.RIGHT))
        assertEquals(2, Direction.angle(Direction.UP, Direction.DOWN))
        assertEquals(1, Direction.angle(Direction.UP, Direction.LEFT))
        assertEquals(1, Direction.angle(Direction.RIGHT, Direction.UP))
        assertEquals(0, Direction.angle(Direction.RIGHT, Direction.RIGHT))
        assertEquals(3, Direction.angle(Direction.RIGHT, Direction.DOWN))
        assertEquals(2, Direction.angle(Direction.RIGHT, Direction.LEFT))
        assertEquals(2, Direction.angle(Direction.DOWN, Direction.UP))
        assertEquals(1, Direction.angle(Direction.DOWN, Direction.RIGHT))
        assertEquals(0, Direction.angle(Direction.DOWN, Direction.DOWN))
        assertEquals(3, Direction.angle(Direction.DOWN, Direction.LEFT))
        assertEquals(3, Direction.angle(Direction.LEFT, Direction.UP))
        assertEquals(2, Direction.angle(Direction.LEFT, Direction.RIGHT))
        assertEquals(1, Direction.angle(Direction.LEFT, Direction.DOWN))
        assertEquals(0, Direction.angle(Direction.LEFT, Direction.LEFT))
    }

    @Test
    fun testRightAngle() {
        assertFalse(Direction.rightAngle(Direction.UP, Direction.UP))
        assertTrue(Direction.rightAngle(Direction.UP, Direction.RIGHT))
        assertFalse(Direction.rightAngle(Direction.UP, Direction.DOWN))
        assertTrue(Direction.rightAngle(Direction.UP, Direction.LEFT))
        assertTrue(Direction.rightAngle(Direction.RIGHT, Direction.UP))
        assertFalse(Direction.rightAngle(Direction.RIGHT, Direction.RIGHT))
        assertTrue(Direction.rightAngle(Direction.RIGHT, Direction.DOWN))
        assertFalse(Direction.rightAngle(Direction.RIGHT, Direction.LEFT))
        assertFalse(Direction.rightAngle(Direction.DOWN, Direction.UP))
        assertTrue(Direction.rightAngle(Direction.DOWN, Direction.RIGHT))
        assertFalse(Direction.rightAngle(Direction.DOWN, Direction.DOWN))
        assertTrue(Direction.rightAngle(Direction.DOWN, Direction.LEFT))
        assertTrue(Direction.rightAngle(Direction.LEFT, Direction.UP))
        assertFalse(Direction.rightAngle(Direction.LEFT, Direction.RIGHT))
        assertTrue(Direction.rightAngle(Direction.LEFT, Direction.DOWN))
        assertFalse(Direction.rightAngle(Direction.LEFT, Direction.LEFT))
    }

}
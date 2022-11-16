package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equalsTest(){
        assertFalse(new Vector2d(1, 1).equals(new Vector2d(1, 0)));
        assertTrue(new Vector2d(1, 1).equals(new Vector2d(1, 1)));
    }

    @Test
    void toStringTest(){
        assertEquals(new Vector2d(2,3).toString(), "(2,3)");
    }

    @Test
    void precedesTest(){
        assertTrue(new Vector2d(4, 4).precedes(new Vector2d(4, 4)));
        assertTrue(new Vector2d(4, 7).precedes(new Vector2d(4, 8)));
        assertFalse(new Vector2d(4, 7).precedes(new Vector2d(4, 2)));
        assertFalse(new Vector2d(4, 7).precedes(new Vector2d(2, 2)));
        assertTrue(new Vector2d(4, 7).precedes(new Vector2d(4, 7)));
    }

    @Test
    void followsTest(){
        assertTrue(new Vector2d(4, 4).follows(new Vector2d(4, 4)));
        assertFalse(new Vector2d(4, 7).follows(new Vector2d(4, 8)));
        assertTrue(new Vector2d(4, 7).follows(new Vector2d(4, 2)));
        assertTrue(new Vector2d(4, 7).follows(new Vector2d(2, 2)));
        assertTrue(new Vector2d(4, 7).follows(new Vector2d(4, 7)));
    }

    @Test
    void upperRightTest(){
        assertEquals(new Vector2d(4,7).upperRight(new Vector2d(2,8)),
                new Vector2d(4,8));
        assertEquals(new Vector2d(-2,-3).upperRight(new Vector2d(-5,2)),
                new Vector2d(-2,2));
        assertEquals(new Vector2d(1,1).upperRight(new Vector2d(1,1)),
                new Vector2d(1,1));
    }

    @Test
    void lowerLeftTest(){
        assertEquals(new Vector2d(4,7).lowerLeft(new Vector2d(2,8)),
                new Vector2d(2,7));
        assertEquals(new Vector2d(-2,-3).lowerLeft(new Vector2d(-5,2)),
                new Vector2d(-5,-3));
        assertEquals(new Vector2d(1,1).lowerLeft(new Vector2d(1,1)),
                new Vector2d(1,1));
    }

    @Test
    void addTest(){
        assertEquals(new Vector2d(4,7).add(new Vector2d(2,8)),
                new Vector2d(6,15));
    }

    @Test
    void subtractTest(){
        assertEquals(new Vector2d(4,7).subtract(new Vector2d(2,8)),
                new Vector2d(2,-1));
    }

    @Test
    void oppositeTest(){
        assertEquals(new Vector2d(4,7).opposite(),
                new Vector2d(-4,-7));
        assertEquals(new Vector2d(-2,-2).opposite(),
                new Vector2d(2,2));
        assertEquals(new Vector2d(0,0).opposite(),
                new Vector2d(0,0));
    }
}

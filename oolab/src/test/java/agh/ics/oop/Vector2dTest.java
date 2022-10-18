package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {
    @Test
    void equalsTest(){
        assertEquals(new Vector2d(1,1).equals(new Vector2d(1,0)), false);
        assertEquals(new Vector2d(1,1).equals(new Vector2d(1,1)), true);
    }

    @Test
    void toStringTest(){
        assertEquals(new Vector2d(2,3).toString(), "(2,3)");
    }

    @Test
    void precedesTest(){
        assertEquals(new Vector2d(4,4).precedes(new Vector2d(4,4)), true);
        assertEquals(new Vector2d(4,7).precedes(new Vector2d(4,8)), true);
        assertEquals(new Vector2d(4,7).precedes(new Vector2d(4,2)), false);
        assertEquals(new Vector2d(4,7).precedes(new Vector2d(2,2)), false);
        assertEquals(new Vector2d(4,7).precedes(new Vector2d(4,7)), true);
    }

    @Test
    void followsTest(){
        assertEquals(new Vector2d(4,4).follows(new Vector2d(4,4)), true);
        assertEquals(new Vector2d(4,7).follows(new Vector2d(4,8)), false);
        assertEquals(new Vector2d(4,7).follows(new Vector2d(4,2)), true);
        assertEquals(new Vector2d(4,7).follows(new Vector2d(2,2)), true);
        assertEquals(new Vector2d(4,7).follows(new Vector2d(4,7)), true);
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
    void substractTest(){
        assertEquals(new Vector2d(4,7).substract(new Vector2d(2,8)),
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

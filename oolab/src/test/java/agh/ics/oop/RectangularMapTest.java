package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangularMapTest {
    @Test
    void objectAtTest(){
        RectangularMap map1 = new RectangularMap(5,5);
        Animal a1 = new Animal(map1, new Vector2d(1,3));
        map1.elements.add(a1);
        assertEquals(a1, map1.objectAt(new Vector2d(1,3)));
    }

    @Test
    void isOccupied(){
        RectangularMap map2 = new RectangularMap(7,9);
        Animal a2 = new Animal(map2, new Vector2d(4,1));
        map2.elements.add(a2);
        assertTrue(map2.isOccupied(new Vector2d(4,1)));
    }

    @Test
    void place(){
        RectangularMap map3 = new RectangularMap(8,8);
        Animal a3 = new Animal(map3, new Vector2d(5,8));
        assertTrue(map3.place(a3));
        assertTrue(a3.isAt(new Vector2d(5,8)));
    }

    @Test
    void canMoveTo(){
        RectangularMap map4 = new RectangularMap(11, 5);
        Animal a4 = new Animal(map4, new Vector2d(2,3));
        map4.elements.add(a4);
        assertTrue(map4.canMoveTo(new Vector2d(3,3)));
    }
}

package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    void objectAtTest(){
        GrassField field1 = new GrassField(10);
        Animal a1 = new Animal(field1, new Vector2d(4,2));
        field1.animals.add(a1);
        assertEquals(a1, field1.objectAt(new Vector2d(4,2)));
    }

    @Test
    void isOccupied(){
        GrassField field2 = new GrassField(8);
        Animal a2 = new Animal(field2, new Vector2d(5,8));
        field2.animals.add(a2);
        assertTrue(field2.isOccupied(new Vector2d(5,8)));
    }

    @Test
    void place(){
        GrassField field3 = new GrassField(12);
        Animal a3 = new Animal(field3, new Vector2d(5,8));
        assertTrue(field3.place(a3));
        assertTrue(a3.isAt(new Vector2d(5,8)));
    }

    @Test
    void canMoveTo(){
        GrassField field4 = new GrassField(12);
        Animal a4 = new Animal(field4, new Vector2d(5,8));
        field4.animals.add(a4);
        assertTrue(field4.canMoveTo(new Vector2d(5,7)));
    }
}

package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorldIT {

    @Test
    void dataTest(){
        OptionsParser p = new OptionsParser();
        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD,
                MoveDirection.RIGHT, MoveDirection.LEFT},
                p.parse(new String[]{"f", "r", "v", "b", "r", "l"}));
    }

    @Test
    void orientationTest(){
        Animal a1 = new Animal();
        OptionsParser parser1 = new OptionsParser();
        MoveDirection[] dir1 = parser1.parse(new String[]{"l", "r", "r", "u", "r", "l"});
        for(MoveDirection direction : dir1) a1.move(direction);
        assertEquals("Orientacja: Wschód, Pozycja: (2,2)", a1.toString());
    }

    @Test
    void movementTest(){
        Animal a2 = new Animal();
        OptionsParser parser2 = new OptionsParser();
        MoveDirection[] dir2 = parser2.parse(new String[]{"l", "f", "r", "f", "l", "p"});
        for(MoveDirection direction : dir2) a2.move(direction);
        assertEquals("Orientacja: Zachód, Pozycja: (1,3)", a2.toString());
    }

    @Test
    void noExitTest(){
        Animal a3 = new Animal();
        OptionsParser parser3 = new OptionsParser();
        MoveDirection[] dir3 = parser3.parse(new String[]{"f", "f", "r", "f", "f", "l", "f", "f"});
        for(MoveDirection direction : dir3) a3.move(direction);
        assertEquals("Orientacja: Północ, Pozycja: (4,4)", a3.toString());
    }
}

package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void run(MoveDirection[] directions) {
        //System.out.println("Do przodu");
//        for (int i = 0; i < directions.length; i++) {
//            if (i != directions.length - 1) System.out.print(directions[i] + ",");
//            else System.out.println(directions[i]);
//        }
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] != null) {
                String s = switch (directions[i]) {
                    case FORWARD -> "Zwierzak idzie do przodu";
                    case BACKWARD -> "Zwierzak idzie do tyłu";
                    case RIGHT -> "Zwierzak skręca w prawo";
                    case LEFT -> "Zwierzak skręca w lewo";
                };
                System.out.println(s);
            }
        }
    }

    public static MoveDirection[] change(String[] args){
        MoveDirection[] dir = new MoveDirection[args.length];
        for(int i = 0; i < args.length; i++){
            dir[i] = switch(args[i]){
                case "f" -> MoveDirection.FORWARD;
                case "b"-> MoveDirection.BACKWARD;
                case "l"-> MoveDirection.LEFT;
                case "r"-> MoveDirection.RIGHT;
                default -> null;
            };
        }
        return dir;
    }

    public static void main(String[] args) {
//        System.out.println("Start");
//        MoveDirection[] directions = change(args);
//        run(directions);
//        System.out.println("Stop");
//        System.out.println();
//
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//
//        MapDirection md1 = MapDirection.WEST;
//        System.out.println();
//        System.out.println(md1);
//        System.out.println(md1.next());
//        System.out.println(md1.previous());
//        System.out.println(md1.toUnitVector());
//
//        System.out.println();
//        System.out.println(new Animal());
//
//        System.out.println();
//        Animal animal1 = new Animal();
//        System.out.println("Start");
//        animal1.move(MoveDirection.RIGHT);
//        animal1.move(MoveDirection.FORWARD);
//        animal1.move(MoveDirection.FORWARD);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println("Stop");
//
//        Animal animal2 = new Animal();
//        OptionsParser parser = new OptionsParser();
//        System.out.println();
//        System.out.println("Start");
//        MoveDirection[] directions1 = parser.parse(new String[]{"r", "f", "f", "f", "s", "p"});
//        for(MoveDirection direction : directions1) animal2.move(direction);
//        System.out.println("Stop");
//        System.out.println();

        //lab3_zad 10: dodać kolekcję grupującą współrzędne zwierząt i dodać warunek do ifa dla case FORWARD i BACKWARD
        // w switchu w metodzie main sprwdzajcego czy nowego położenia zwierzęcia nie ma w kolekcji, jeśli nie to
        // przesuwamy zwierzę na nową pozycję i dodajemy nowe koordynaty do kolekcji, jeśli  jest to nie wykonujemy
        // przejścia

//        RectangularMap rectangularMap = new RectangularMap(4,4);
//        System.out.println(rectangularMap);
//        Animal a = new Animal(map, new Vector2d(2,2));
//        map.place(a);
//        System.out.println(map.objectAt(new Vector2d(2,2)));

        Application.launch(App.class, args);
    }


}

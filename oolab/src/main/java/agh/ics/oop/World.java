package agh.ics.oop;

public class World {
    public static void run(Direction[] directions) {
        System.out.println("Do przodu");
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

    public static Direction[] change(String[] args){
        Direction[] dir = new Direction[10];
        for(int i = 0; i < args.length; i++){
            dir[i] = switch(args[i]){
                case "f" -> Direction.FORWARD;
                case "b"-> Direction.BACKWARD;
                case "l"-> Direction.LEFT;
                case "r"-> Direction.RIGHT;
                default -> null;
            };
        }
        return dir;
    }

    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] directions = change(args);
        run(directions);
        System.out.println("Stop");
        System.out.println();

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection md1 = MapDirection.WEST;
        System.out.println();
        System.out.println(md1);
        System.out.println(md1.next());
        System.out.println(md1.previous());
        System.out.println(md1.toUnitVector());
    }


}

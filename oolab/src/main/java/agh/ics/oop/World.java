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

    }
}

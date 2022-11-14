package agh.ics.oop;

public class Animal {
    private MapDirection animalDir = MapDirection.NORTH;
    private Vector2d animalVect = new Vector2d(2, 2);

    private IWorldMap map;


    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        animalVect = initialPosition;
    }

    public Animal() {
    }


    public String toString() {
        String orientation = switch (this.animalDir){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
        //return "Orientacja: " + this.animalDir.toString() + ", Pozycja: " + this.animalVect.toString();
        return orientation;
    }

    public boolean isAt(Vector2d position) {
        return position.x == this.animalVect.x
                && position.y == this.animalVect.y;
    }

    public Vector2d getPosition(){
        return this.animalVect;
    }

    public void move(MoveDirection direction) {
//        switch (direction) {
//            case RIGHT -> animalDir = animalDir.next();
//            case LEFT -> animalDir = animalDir.previous();
//            case FORWARD -> {
//                if (animalVect.add(animalDir.toUnitVector()).precedes(new Vector2d(4, 4)) &&
//                        animalVect.add(animalDir.toUnitVector()).follows(new Vector2d(0, 0))) {
//                    animalVect = animalVect.add(animalDir.toUnitVector());
//                }
//            }
//            case BACKWARD -> {
//                if (animalVect.subtract(animalDir.toUnitVector()).precedes(new Vector2d(4, 4)) &&
//                        animalVect.subtract(animalDir.toUnitVector()).follows(new Vector2d(0, 0))) {
//                    animalVect = animalVect.subtract(animalDir.toUnitVector());
//                }
//            }
//        }

        switch (direction) {
            case RIGHT -> animalDir = animalDir.next();
            case LEFT -> animalDir = animalDir.previous();
            case FORWARD -> {
                if (map.canMoveTo(animalVect.add(animalDir.toUnitVector()))) {
                    animalVect = animalVect.add(animalDir.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(animalVect.subtract(animalDir.toUnitVector()))) {
                    animalVect = animalVect.subtract(animalDir.toUnitVector());
                }
            }
        }
        //System.out.println(this);
    }
}
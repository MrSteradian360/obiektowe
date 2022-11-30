package agh.ics.oop;

public class Animal extends AbstractWorldMapElement {
    private MapDirection animalDir = MapDirection.NORTH;
    //protected Vector2d position = new Vector2d(2, 2);

    private IWorldMap map;


    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        super.position = initialPosition;
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

    public void move(MoveDirection direction) {

        switch (direction) {
            case RIGHT -> animalDir = animalDir.next();
            case LEFT -> animalDir = animalDir.previous();
            case FORWARD -> {
                if (map.canMoveTo(position.add(animalDir.toUnitVector()))) {
                    position = position.add(animalDir.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(animalDir.toUnitVector()))) {
                    position = position.subtract(animalDir.toUnitVector());
                }
            }
        }
    }
}
package agh.ics.oop;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Animal extends AbstractWorldMapElement {
    private MapDirection animalDir = MapDirection.NORTH;
    //protected Vector2d position = new Vector2d(2, 2);

    private LinkedList<IPositionChangeObserver> observers = new LinkedList<>();

    private IWorldMap map;


    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        super.position = initialPosition;
    }


    public String toString() {
        //return "Orientacja: " + this.animalDir.toString() + ", Pozycja: " + this.animalVect.toString();
        String o = switch (this.animalDir){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
        return o;
    }

    public void move(MoveDirection direction) {

        switch (direction) {
            case RIGHT -> animalDir = animalDir.next();
            case LEFT -> animalDir = animalDir.previous();
            case FORWARD -> {
                if (map.canMoveTo(position.add(animalDir.toUnitVector()))) {
                    this.positionChanged(position.add(animalDir.toUnitVector()));
                    position = position.add(animalDir.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(animalDir.toUnitVector()))) {
                    this.positionChanged(position.subtract(animalDir.toUnitVector()));
                    position = position.subtract(animalDir.toUnitVector());
                }
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) observer.positionChanged(this.position, newPosition);
    }

    @Override
    public String getElementPath() {
        return switch (this.animalDir){
            case NORTH -> "src/main/resources/up.png";
            case SOUTH -> "src/main/resources/down.png";
            case EAST -> "src/main/resources/right.png";
            case WEST -> "src/main/resources/left.png";
        };
    }
}
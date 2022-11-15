package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;

    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position) || !(position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0))))
            return false;
        else return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) return false;
        else {
            animals.add(animal);
            return true;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : animals){
            if (a.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a : animals){
            if (a.isAt(position)){
                return a;
            }
        }
        return null;
    }

}

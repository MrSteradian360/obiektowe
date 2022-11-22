package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    //protected List<Animal> animals = new ArrayList<>();
    protected List<IMapElement> elements = new ArrayList<>();
    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) return false;
        else {
            elements.add(animal);
            return true;
        }
    }
    @Override
    public Object objectAt(Vector2d position) {
        return elements.stream().filter(animal -> animal.isAt(position) && animal instanceof Animal).findFirst().orElse(null);
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(getWidth(), getHeight()));
    }

    public int getWidth(){
        return 10;
    }

    public int getHeight(){
        return 10;
    }

}

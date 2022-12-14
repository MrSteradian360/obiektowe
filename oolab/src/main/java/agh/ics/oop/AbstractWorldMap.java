package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    //protected List<Animal> animals = new ArrayList<>();
    //protected List<IMapElement> elements = new ArrayList<>();

    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Map<Vector2d, Grass> grasses = new HashMap<>();

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) throw new IllegalArgumentException(animal.getPosition() + " - animal cannot be placed on this field");
        else {
            //elements.add(animal);
            animals.put(animal.getPosition(), animal);
            System.out.println(animal.getPosition()+" place");
            return true;
        }
    }
    @Override
    public Object objectAt(Vector2d position) {
        //return elements.stream().filter(animal -> animal.isAt(position) && animal instanceof Animal).findFirst().orElse(null);
        //return animals.entrySet().stream().filter(animal -> animal.getKey().equals(position)).findFirst().orElse(null).getValue();
        return animals.get(position);
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(getWidth(), getHeight()));
    }

//    public int getWidth(){
//        return 10;
//    }
//
//    public int getHeight(){
//        return 10;
//    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition);
    }



}

package agh.ics.oop;

import java.util.*;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public Collection<IMapElement> getElements(){
        return Collections.unmodifiableCollection(elements);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0));
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    //@Override
    //public boolean isOccupied(Vector2d position) {
    //return objectAt(position) != null;

    //return animals.stream().allMatch(x -> x.isAt(position));

//        for (Animal a : animals){
//            if (a.isAt(position)){
//                return true;
//            }
//        }
//        return false;
    //}



}

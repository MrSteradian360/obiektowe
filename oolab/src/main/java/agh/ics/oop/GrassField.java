package agh.ics.oop;

import javafx.beans.property.MapPropertyBase;
import org.w3c.dom.html.HTMLMapElement;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class GrassField extends AbstractWorldMap{

    private int fieldsNum;
    private Vector2d[] positionsVect;

    private MapBoundary mapBoundary = new MapBoundary();



    public GrassField(int fieldsNum) {
        this.fieldsNum = fieldsNum;
        int fieldsRoot = (int)Math.sqrt(10*(double)fieldsNum);
        System.out.println(fieldsRoot);
        List<Integer> positions = IntStream.range(0, fieldsRoot*fieldsRoot)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(positions);
        Collections.shuffle(positions);
        System.out.println(positions);
        int[] array = positions.stream().mapToInt(i -> i).toArray();
        Object[] positionsArray =  Arrays.stream(array)
                .limit(fieldsNum)
                .mapToObj(x -> new Vector2d(x/fieldsRoot, x%fieldsRoot))
                .toArray();
        positionsVect = new Vector2d[positionsArray.length];
        System.arraycopy(positionsArray, 0, this.positionsVect, 0, positionsArray.length);
        for (Vector2d position : positionsVect) {
            grasses.put(position, new Grass(position));
            mapBoundary.addPosition(position);
        }

        //for (Vector2d position : positionsVect) elements.put(position, new Grass(position));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object o1 = super.objectAt(position);
        //Object o2 = grasses.stream().filter(grass -> grass.isAt(position)).findFirst().orElse(null);
        if (o1 != null) return o1;
        else return grasses.get(position);
        //Object o1 = elements.entrySet().stream().filter(element -> element.getKey().equals(position)&& element instanceof Animal).findFirst().orElse(null).getValue();
        //Object o1 = elements.get(position);
        //if (o1 != null) return o1;
        //return elements.entrySet().stream().filter(element -> element.getKey().equals(position)).findFirst().orElse(null).getValue();
        //return elements.get()
    }

    @Override
    public int getWidth() {
//        return Arrays.stream(positionsVect).max(new Comparator<Vector2d>() {
//            @Override
//            public int compare(Vector2d o1, Vector2d o2) {
//                return Integer.compare(o1.x, o2.x);
//            }
//        }).orElse(new Vector2d(0,0)).getX();
        return mapBoundary.getSetX().last().getX();
    }

    public int getMinWidth(){
        return mapBoundary.getSetX().first().getX();
    }

    @Override
    public int getHeight() {
//        return Arrays.stream(positionsVect).max(new Comparator<Vector2d>() {
//            @Override
//            public int compare(Vector2d o1, Vector2d o2) {
//                return Integer.compare(o1.y, o2.y);
//            }
//        }).orElse(new Vector2d(0,0)).getY();
        return mapBoundary.getSetY().last().getY();
    }

    public int getMinHeight(){
        return mapBoundary.getSetY().first().getY();
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }

    @Override
    public boolean place(Animal animal) {
        if (super.place(animal)) {
            mapBoundary.addPosition(animal.getPosition());
            return true;
        }
        return false;
    }


}

package agh.ics.oop;

import org.w3c.dom.html.HTMLMapElement;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class GrassField extends AbstractWorldMap{

    private int fieldsNum;
    private Vector2d[] positionsVect;

    //private List<Grass> grasses = new ArrayList<>();

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
        //for (Vector2d position : positionsVect) grasses.add(new Grass(position));
        for (Vector2d position : positionsVect) elements.add(new Grass(position));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }


    @Override
    public Object objectAt(Vector2d position) {
        //Object o1 = super.objectAt(position);
        //Object o2 = grasses.stream().filter(grass -> grass.isAt(position)).findFirst().orElse(null);
        //if (o1 != null) return o1;
        //else return o2;
        Object o1 = elements.stream().filter(element -> element.isAt(position) && element instanceof Animal).findFirst().orElse(null);
        Object o2 = elements.stream().filter(element -> element.isAt(position)).findFirst().orElse(null);
        if (o1 != null) return o1;
        else return o2;
    }

    @Override
    public int getWidth() {
        return Arrays.stream(positionsVect).max(new Comparator<Vector2d>() {
            @Override
            public int compare(Vector2d o1, Vector2d o2) {
                return Integer.compare(o1.x, o2.x);
            }
        }).orElse(new Vector2d(0,0)).getX();
    }

    @Override
    public int getHeight() {
        return Arrays.stream(positionsVect).max(new Comparator<Vector2d>() {
            @Override
            public int compare(Vector2d o1, Vector2d o2) {
                return Integer.compare(o1.y, o2.y);
            }
        }).orElse(new Vector2d(0,0)).getY();
    }


}

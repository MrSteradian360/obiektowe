package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    private SortedSet<Vector2d> setX = new TreeSet<Vector2d>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            //return o1.getX() > o2.getX() ? 1 : (o1.getX() < o2.getX() ? -1 : (o1.getY() > o2.getY() ? 1 : -1));
            return Integer.compare(o1.getX(), o2.getX());
        }
    });
    private SortedSet<Vector2d> setY = new TreeSet<Vector2d>(new Comparator  <Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            return Integer.compare(o1.getY(), o2.getY());
        }
    });

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        addPosition(newPosition);
        removePosition(oldPosition);
    }

    public void addPosition(Vector2d position){
        setX.add(position);
        setY.add(position);
    }

    public void removePosition(Vector2d position){
        setX.remove(position);
        setY.remove(position);
    }

    public SortedSet<Vector2d> getSetX() {
        return setX;
    }

    public SortedSet<Vector2d> getSetY() {
        return setY;
    }
}

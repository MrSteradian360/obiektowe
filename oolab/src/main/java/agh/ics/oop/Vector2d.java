package agh.ics.oop;

import java.util.Comparator;
import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x  = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return String.format("(%d,%d)", x, y);
    }

    boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }

    boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other){
        int x1 = Math.max(this.x, other.x);
        int y1 = Math.max(this.y, other.y);
        return new Vector2d(x1,y1);
    }

    public Vector2d lowerLeft(Vector2d other){
        int x1 = Math.min(this.x, other.x);
        int y1 = Math.min(this.y, other.y);
        return new Vector2d(x1,y1);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d that))
            return false;
        return that.x == x && that.y == y;
    }

    public Vector2d  opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

//    @Override
//    public int compareTo(Vector2d o) {
//        if(this.x > this.o)
//    }
}

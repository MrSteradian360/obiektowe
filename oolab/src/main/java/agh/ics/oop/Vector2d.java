package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x  = x;
        this.y = y;
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
        int x1 = this.x > x ? this.x : x;
        int y1 = this.y > y ? this.y : y;
        return new Vector2d(x1,y1);
    }

    public Vector2d lowerLeft(Vector2d other){
        int x1 = this.x < x ? this.x : x;
        int y1 = this.y < y ? this.y : y;
        return new Vector2d(x1,y1);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + x, this.y + y);
    }

    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x - x, this.y - y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return that.x == x && that.y == y;
    }

    public Vector2d  opposite(){
        return new Vector2d(-this.x, -this.y);
    }

}

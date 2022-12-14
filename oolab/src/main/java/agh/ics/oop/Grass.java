package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{
    public Grass(Vector2d position){
        this.position = position;
    }

    public String toString(){
        return "Trawa";
    }

    @Override
    public String getElementPath() {
        return "src/main/resources/grass.png";
    }
}

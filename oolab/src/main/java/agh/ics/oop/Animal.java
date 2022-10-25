package agh.ics.oop;

public class Animal {
    private MapDirection animalDir = MapDirection.NORTH;
    private Vector2d animalVect = new Vector2d(2,2);

    public String toString(){
        return "Orientacja: " + this.animalDir.toString() + ", Pozycja: " + this.animalVect.toString();
    }

    public boolean isAt(Vector2d position){
        return position.x == this.animalVect.x
                && position.y == this.animalVect.y;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> animalDir = animalDir.next();
            case LEFT -> animalDir = animalDir.previous();
            case FORWARD -> {
                if (animalVect.add(animalDir.toUnitVector()).precedes(new Vector2d(4, 4)) &&
                        animalVect.add(animalDir.toUnitVector()).follows(new Vector2d(0, 0))) {
                    animalVect = animalVect.add(animalDir.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (animalVect.subtract(animalDir.toUnitVector()).precedes(new Vector2d(4, 4)) &&
                        animalVect.subtract(animalDir.toUnitVector()).follows(new Vector2d(0, 0))) {
                    animalVect = animalVect.subtract(animalDir.toUnitVector());
                }
            }
        }
        System.out.println(this);
    }


}

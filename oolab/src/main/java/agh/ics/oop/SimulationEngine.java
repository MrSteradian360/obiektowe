package agh.ics.oop;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moveDirection;
    private IWorldMap map;
    private Vector2d[] positions;

    public SimulationEngine(MoveDirection[] moveDirection, IWorldMap map, Vector2d[] positions){
        this.map = map;
        this.moveDirection = moveDirection;
        this.positions = positions;
        for (Vector2d v : positions){
            map.place(new Animal(map, v));
        }
    }

    @Override
    public void run() {
        System.out.println(positions.length);
        System.out.println(moveDirection.length);
        Vector2d[] pos = positions;
        for (int i = 0; i < this.moveDirection.length; i++){
            Animal a = ((Animal) map.objectAt(pos[i % positions.length]));
            a.move(moveDirection[i]);
            pos[i % positions.length] = a.getPosition();
        }
    }
}

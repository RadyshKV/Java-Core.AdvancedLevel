package HomeWork1;

public class Wall implements Obstacle {
    private float height;

    Wall(float height) {
        this.height = height;
    }

    @Override
    public boolean start(Participant participant) {
        return jump (participant);
    }

    public boolean jump (Participant participant){
        return participant.jump(height);
    }
}

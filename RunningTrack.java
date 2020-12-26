package HomeWork1;

public class RunningTrack implements Obstacle {
    private float length;

    RunningTrack(float length) {
        this.length = length;
    }


    @Override
    public boolean start(Participant participant) {
        return run (participant);
    }

    public boolean run(Participant participant){
        return participant.run(length);
    }
}

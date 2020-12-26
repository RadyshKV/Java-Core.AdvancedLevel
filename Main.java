package HomeWork1;

public class Main {


    public static void main(String[] args) {
        // write your code here

        boolean finish = false;

        Cat cat = new Cat("Мурзик", 1.5F, 350);
        Human human = new Human("Владимир", 1.2F, 1000);
        Robot robot = new Robot("Андроид", 0.5F, 300);

        RunningTrack runningTrack = new RunningTrack(300);
        Wall wall = new Wall(1.0F);


        Participant[] participants = {cat, human, robot};
        Obstacle[] obstacles = {runningTrack, wall};

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                finish = obstacles[j].start(participants[i]);
                if (!finish) break;
            }
            if (finish) {
                System.out.println("Забег пройден");
            }
            else{
                System.out.println("Забег не пройден");
            }
        }
    }
}

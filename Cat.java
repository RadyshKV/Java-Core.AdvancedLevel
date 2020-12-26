package HomeWork1;

public class Cat implements Participant {

    private String name;
    private float maxRun;
    private float maxJump;

    Cat(String name, float maxJump, float maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.name = name;
    }


    @Override
    public boolean run( float distance) {
        System.out.println("Кот " + name + " может пробежать " + maxRun + " метров и пытается пробежать " + distance + " метров");
        if (distance <= maxRun){
            System.out.println("Это получилось");
            return true;
        } else {
            System.out.println("Это не получилось");
            return false;
        }
    }

    @Override
    public boolean jump(float height) {
        System.out.println("Кот " + name + " может прыгнуть на " + maxJump + " метров и пытается прыгнуть на " + height + " метров");
        if (height <= maxJump){
            System.out.println("Это получилось");
            return true;
        } else {
            System.out.println("Это не получилось");
            return false;
        }

    }
}

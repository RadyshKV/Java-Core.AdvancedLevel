package HomeWork5;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        methodOneThread(arr);
        methodTwoThread(arr);
    }

    public static void methodOneThread(float[] arr){
        initArray(arr);
        System.out.println("Метод 1");
        long a = System.currentTimeMillis();
        mathMethod(arr,0);
        System.out.println(System.currentTimeMillis() - a);
        //printArray(arr);
    }



    public static void methodTwoThread(float[] arr){
        initArray(arr);
        System.out.println("Метод 2");
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        Thread t1 = new Thread(() -> mathMethod(a1, 0));
        Thread t2 = new Thread(() -> mathMethod(a2, HALF));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println(System.currentTimeMillis() - a);
        //printArray(arr);
    }

    private static void mathMethod(float[] arr, int shift) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + shift) / 5) * Math.cos(0.2f + (i + shift) / 5) * Math.cos(0.4f + (i + shift) / 2));
        }
    }

    public static void initArray(float[] arr) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
    }

    public static void printArray(float[] arr) {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

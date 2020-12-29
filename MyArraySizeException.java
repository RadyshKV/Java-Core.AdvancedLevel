package HomeWork2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int row, int col) {
        super(String.format("Размер массива - %dх%d не соответствует размеру 4х4", row, col));
    }
}

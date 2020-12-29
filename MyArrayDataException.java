package HomeWork2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super(String.format("В ячейке [%d][%d] содержится не число в формате int", row, col));
    }
}

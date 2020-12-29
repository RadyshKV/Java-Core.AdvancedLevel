package HomeWork2;

public class Main {
    public static final int ARRAY_SYZE = 4;

    public static void main(String[] args) {

        String[][] array = {    {"100", "200", "234", "123"},
                                {"100", "200", "234", "123"},
                                {"c", "200", "234", "123"},
                                {"100", "200", "234", "123"} };

        try{
            System.out.println(arrayStrToIntCalculate(array));
        }
        catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }

    }

    public static int arrayStrToIntCalculate (String[][] array) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;

        if (array.length != ARRAY_SYZE | array[0].length != ARRAY_SYZE)
            throw new MyArraySizeException(array.length, array[0].length);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}


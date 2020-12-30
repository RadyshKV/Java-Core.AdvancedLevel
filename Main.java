package HomeWork3;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Random;


public class Main {
    private static final int ARRAY_SIZE = 20;
    private static final int WORD_SIZE = 2;
    private static final int NUMBER_SIZE = 7;
    private static final Random RND = new Random();
    private static final int CHAR_NUMBER = 65;
    private static final int CHAR_RANGE_TEST = 5;
    private static final int DIGIT_NUMBER = 48;
    private static final int DIGIT_RANGE = 10;

    private static int count = 0;

    public static void main(String[] args) {

        // #1
        String[] stringArray = new String[ARRAY_SIZE];
        HashMap<String, Integer> map = new HashMap<>();

        fillArray(stringArray);

        for (String keyWord : stringArray) {
            if (map.containsKey(keyWord)) {
                map.put(keyWord, map.get(keyWord) + 1);
            }
            else {
                map.put(keyWord, 1);
            }
        }

        map.forEach((keyWord, quantity) -> {
            count++;
            System.out.println(MessageFormat.format("Слово {0} встречается {1} раз", keyWord, quantity));
        });
        System.out.println(MessageFormat.format("Уникальных слов {0} из {1}", count, ARRAY_SIZE));

        // #2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Сидоров", generateWords(NUMBER_SIZE, DIGIT_NUMBER, DIGIT_RANGE));
        phoneBook.add("Иванов", generateWords(NUMBER_SIZE, DIGIT_NUMBER, DIGIT_RANGE));
        phoneBook.add("Пупкин", generateWords(NUMBER_SIZE, DIGIT_NUMBER, DIGIT_RANGE));
        phoneBook.add("Пупкин", generateWords(NUMBER_SIZE, DIGIT_NUMBER, DIGIT_RANGE));
        phoneBook.add("Пупкин", generateWords(NUMBER_SIZE, DIGIT_NUMBER, DIGIT_RANGE));


        System.out.println("Телефонные номера для фамилии Сидоров:\n" + phoneBook.get("Сидоров"));
        System.out.println("Телефонные номера для фамилии Иванов:\n" + phoneBook.get("Иванов"));
        System.out.println("Телефонные номера для фамилии Пупкин:\n" + phoneBook.get("Пупкин"));
    }


    private static String generateWords(int wordSize, int firstChar, int range) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < wordSize; i++)
            sequence.append((char) (firstChar + RND.nextInt(range)));
        return sequence.toString();
    }

    private static void fillArray (String[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = generateWords(WORD_SIZE, CHAR_NUMBER, CHAR_RANGE_TEST);
        }
    }
}

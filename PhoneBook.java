package HomeWork3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private HashMap<String, ArrayList<String>> PhoneBookMap;

    public PhoneBook() {
        this.PhoneBookMap = new HashMap();
    }

    protected boolean add(String familyName, String phoneNumber){
        boolean result;
        if (PhoneBookMap.containsKey(familyName)) {
            return PhoneBookMap.get(familyName).add(phoneNumber);
        }

        ArrayList<String> phoneNumbers = new ArrayList<>();
        result = phoneNumbers.add(phoneNumber);
        PhoneBookMap.put(familyName, phoneNumbers);

        return result;
    }

    protected ArrayList get(String familyName){
        return PhoneBookMap.get(familyName);
    }
}

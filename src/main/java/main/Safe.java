//Nimi: Aida Liukkonen
//Päivämäärä: 26.1.2026
//Tehtävä: viikko3

package main;

import java.util.ArrayList;
public class Safe {
    
    private String pinCode;
    private ArrayList<String> safeFolder;

    public Safe(String pincode) {
        this.pinCode = pincode;
        this.safeFolder = new ArrayList<>();
    }

    public void changePin(String newPin) {
        this.pinCode = newPin;
    }

    public void addToSafe(String item) {
        safeFolder.add(item);
    }

    public ArrayList<String> listItems(String pin) {
        if (this.pinCode.equals(pin)) {
            return safeFolder;
        }
        return null; // väärä PIN
    }

}



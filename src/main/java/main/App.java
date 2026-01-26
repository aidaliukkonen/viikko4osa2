//Nimi: Aida Liukkonen
//Päivämäärä: 26.1.2026
//Tehtävä: viikko3

package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Safe safe = new Safe("0000");

        boolean exit = false;

        while (!exit) {
            System.out.println("1) Aseta PIN-koodi");
            System.out.println("2) Lisää tietoja kansioon");
            System.out.println("3) Listaa tiedot kansiosta");
            System.out.println("0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int i = 0;
                String input = sc.nextLine();
                i = Integer.parseInt(input);

                switch (i) {

                    case 1:
                        System.out.println("Anna uusi PIN-koodi:");
                        String newPin = sc.nextLine();
                        safe.changePin(newPin);
                        break;

                    case 2:
                        System.out.println("Anna kansioon lisättävä tieto:");
                        String data = sc.nextLine();
                        safe.addToSafe(data);
                        break;

                    case 3:
                        System.out.println("Anna PIN-koodi:");
                        String pin = sc.nextLine();

                        ArrayList<String> items = safe.listItems(pin);

                        if (items == null) {
                            System.out.println("Väärä PIN-koodi!");
                        } else {
                            for (String s : items) {
                                System.out.println(s);
                            }
                        }
                        break;
                        
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;

                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }

        sc.close();
    }
}


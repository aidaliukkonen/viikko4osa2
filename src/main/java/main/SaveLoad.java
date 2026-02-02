//Nimi: Aida Liukkonen
//Päivämäärä: 2.2.2026
//Tehtävä: viikko4

package main;

import java.io.*;

public class SaveLoad {

    public static void save(Cave cave, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(cave);
            System.out.println("Peli tallennettiin tiedostoon " + filename + ".");
        } catch (Exception e) {
            System.out.println("Tallennus epäonnistui.");
        }
    }

    public static Cave load(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Cave cave = (Cave) in.readObject();
            System.out.println("Peli ladattu tiedostosta " + filename + ". Tervetuloa takaisin, " + cave.player.getName() + ".");
            return cave;
        } catch (Exception e) {
            System.out.println("Lataus epäonnistui.");
            return null;
        }
    }
}


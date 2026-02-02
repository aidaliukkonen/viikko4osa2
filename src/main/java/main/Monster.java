//Nimi: Aida Liukkonen
//Päivämäärä: 2.2.2026
//Tehtävä: viikko4

package main;

import java.io.Serializable;

public class Monster implements Serializable {
    private String type;
    private int health;

    public Monster(String type, int health) {
        this.type = type;
        this.health = health;
    }

    public void printInfo(int number) {
        System.out.println(number + ": " + type + " / " + health + "HP");
    }

    public boolean takeDamage(int dmg) {
        health -= dmg;

        if (health <= 0) {
            System.out.println(type + " kuoli!");
            return true; // Hirviö kuoli
        } else {
            System.out.println("Hirviöllä on " + health + " elämää jäljellä.");
            return false; // Hirviö jäi henkiin
        }
    }

     public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }
}



//Nimi: Aida Liukkonen
//Päivämäärä: 2.2.2026
//Tehtävä: viikko4

package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable {
    public Player player;
    private ArrayList<Monster> monsters = new ArrayList<>();

    public Cave(Player player) {
        this.player = player;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void listMonsters() {
        if (monsters.isEmpty()) {
            System.out.println("Luolassa ei ole hirviöitä.");
            return;
        }

        System.out.println("Luolan hirviöt:");
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).printInfo(i + 1);
        }
    }
    public Monster getMonster(int index) {
        return monsters.get(index);
    }

    public void removeMonster(int index) {
        monsters.remove(index);
    }

    public int monsterCount() {
        return monsters.size();
    }
}


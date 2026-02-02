//Nimi: Aida Liukkonen
//Päivämäärä: 2.2.2026
//Tehtävä: viikko4


package main;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Syötä pelaajan nimi:");
        Player player = new Player(sc.nextLine());

        Cave cave = new Cave(player);

        boolean exit = false;

        while (!exit) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            int i = Integer.parseInt(sc.nextLine());

            switch (i) {

                case 1:
                    System.out.println("Anna hirviön tyyppi:");
                    String type = sc.nextLine();
                    System.out.println("Anna hirviön elämän määrä numerona:");
                    int hp = Integer.parseInt(sc.nextLine());

                    cave.addMonster(new Monster(type, hp));
                    break;

                case 2:
                    cave.listMonsters();
                    break;

                case 3:
                    if (cave.monsterCount() == 0) {
                        System.out.println("Luola on tyhjä.");
                        break;
                    }

                    System.out.println("Valitse hirviö, johon hyökätä:");
                    cave.listMonsters();

                    int idx = Integer.parseInt(sc.nextLine()) - 1;

                    Monster target = cave.getMonster(idx);

                    System.out.println(player.getName() + " hyökkää " + target.getName() + " hirviöön!");

                    boolean died = cave.player.attack(target);

                    if (died) {
                        System.out.println(target.getName() + " on kuollut!");
                        cave.removeMonster(idx);
                    }
                    break;

                case 4:
                    System.out.println("Anna tiedoston nimi, johon peli tallentaa:");
                    SaveLoad.save(cave, sc.nextLine());
                    break;

                case 5:
                    System.out.println("Anna tiedoston nimi, josta peli ladataan:");
                    Cave loaded = SaveLoad.load(sc.nextLine());
                    if (loaded != null) {
                        cave = loaded;
                    }
                    break;

                case 0:
                    System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                    exit = true;
                    break;

                default:
                    System.out.println("Syöte oli väärä.");
                    break;
            }
        }

        sc.close();
    }
}


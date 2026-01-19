//Nimi: Aida Liukkonen
//Päivämäärä: 19.1.2026
//Tehtävä: viikko2

package main;

/**
 * Hello world!
 *
 */
import java.util.Scanner;
public class App {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Anna auton merkki: ");
        String brand = sc.nextLine();
        System.out.print("Anna auton malli: ");
        String model = sc.nextLine();
        Car car = new Car(brand, model);
        int choice = -1;

        while (choice != 0){
            System.out.println("1) Näytä auton tila");
            System.out.println("2) Muokkaa auton merkkiä ja mallia");
            System.out.println("3) Kiihdytä autoa");
            System.out.println("4) Hidasta autoa");
            System.out.println("0) Lopeta ohjelma");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    car.status();
                    break;

                case 2:
                    System.out.print("Anna uusi auton merkki: ");
                    String newBrand = sc.nextLine();

                    System.out.print("Anna uusi auton malli: ");
                    String newModel = sc.nextLine();

                    car.setBrand(newBrand);
                    car.setModel(newModel);
                    break;

                case 3:
                    System.out.print("Kuinka monta km/h haluat kiihdyttää? ");
                    int acc = sc.nextInt();

                    if (acc < 0) {
                        System.out.println("Nopeuden täytyy olla positiivinen luku.");
                    } else {
                        car.accelerate(acc);
                    }
                    break;

                case 4:
                    System.out.print("Kuinka monta km/h haluat hidastaa? ");
                    int dec = sc.nextInt();

                    if (dec < 0) {
                        System.out.println("Nopeuden täytyy olla positiivinen luku.");
                    } else {
                        car.decelerate(dec);
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;

                default:
                    System.out.println("Syöte oli väärä");
                    break;
            }

        }
        sc.close();
    }

}

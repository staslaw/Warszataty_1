package zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();

        int number = r.nextInt(100) + 1;

        Scanner input = new Scanner(System.in);
        System.out.println("Zgadnij liczbę");
        String str;
        int counter = 0;

        while (!((str = input.nextLine()).equals(String.valueOf(number)))) {
            try {
                int x = Integer.parseInt(str);
                if (x < number) {
                    System.out.println("Za mało!");
                    counter ++;
                } else {
                    System.out.println("Za dużo");
                    counter ++;
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba");
            }
        }
        System.out.println("Zgadłeś! Za " + counter + " razem!");
    }
}
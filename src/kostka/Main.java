package kostka;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        int x = 0;
        int y = 0;
        int z = 0;
        int result = 0;
        boolean correct = true;
        String str;

        System.out.println("Podaj kod rzutu kostką zgodnie ze wzorem xDy+z");

        while (correct) {
            str = input.nextLine();

            try {
                x = Integer.parseInt(str.substring(0, str.indexOf("D")));
                if (x <= 0) {
                    System.out.println("Liczba rzutów kostką musi być większa od zera. Spróbuj jeszcze raz");
                    continue;
                }
            } catch (NumberFormatException e) {
                x = 1;
            } catch (StringIndexOutOfBoundsException f) {
                System.out.println("Błędnie wprowadzony kod. Spróbuj jeszcze raz.");
                continue;
            }

            try {
                if (str.contains("+")) {
                    y = Integer.parseInt(str.substring(str.indexOf("D") + 1, str.indexOf("+")));
                } else if (str.contains("-")) {
                    y = Integer.parseInt(str.substring(str.indexOf("D") + 1, str.indexOf("-")));
                } else {
                    y = Integer.parseInt(str.substring(str.indexOf("D") + 1));
                }
                if (y <= 2) {
                    System.out.println("Kostki muszą mieć przynajmniej 3 ściany. Spróbuj jeszcze raz");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Błędnie wprowadzony kod. Spróbuj jeszcze raz.");
                continue;
            }

            try {
                if (str.contains("+")) {
                    z = Integer.parseInt(str.substring(str.indexOf("+") + 1));
                } else if (str.contains("-")) {
                    z = -(Integer.parseInt(str.substring(str.indexOf("-") + 1)));
                } else {
                    z = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Błędnie wprowadzony kod. Spróbuj jeszcze raz.");
                continue;
            }
            System.out.println("Wykonam " + x + " rzutów " + y + "-ścienną kostką i wynik zmodyfikuję o " + z);
            correct = false;
        }


        for (int i = 0; i < x; i++) {
            result += r.nextInt(y) + 1;
        }
        result += z;
        System.out.println("Wynik = " + result);
    }
}
package zgadywanie_liczb2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        int number;
        int zakres = 0;
        int counter = 0;

        System.out.println("Będziemy zgadywać liczbę od 1 do x, podaj x");

        while (counter == 0) {
            counter = 1;
            try {
                while ((zakres = input.nextInt()) <= 0) {
                    System.out.println("Liczba musi być większa od zera");
                    counter = 0;
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Liczba musi być liczbą");
                input.next();
                counter = 0;
                continue;
            }
        }
        System.out.println("Pomyśl sobie liczbę od 1 do " + zakres);
        System.out.println("Jeżeli jesteś gotowy napisz słowo start");
        input.next();
        str = input.nextLine();

        while (!(str.equals("start"))) {
            System.out.println("Błędny komunikat. Jeżeli jesteś gotowy napisz słowo start");
            str = input.nextLine();
        }

        number = zakres / 2;
        System.out.println("Czy pomyślałeś o liczbie: " + number + "?");
        System.out.println("Napisz więcej, mniej lub trafiłeś");

        while (!((str = input.nextLine()).equals("trafiłeś"))) {
            while (!(str.equals("mniej") || str.equals("więcej") || str.equals("trafiłeś"))) {
                System.out.println("Podaj prawidłowy komunikat. Napisz więcej, mniej lub trafiłeś");
            }
            if (str.equals("mniej")) {
                number = number / 2;
                System.out.println("Czy pomyślałeś o liczbie: " + number + "?");
            } else if (str.equals("więcej")) {
                number = number * 3 / 2;
                System.out.println("Czy pomyślałeś o liczbie: " + number + "?");
            } else {
                System.out.println("Zwycięstwo!!");
            }
        }
        System.out.println("Zwycięstwo!!");
    }
}
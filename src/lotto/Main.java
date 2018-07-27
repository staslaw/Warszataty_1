package lotto;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tab[] = new int[6];
        int lotto[] = new int[6];
        Random r = new Random();
        int counter = 0;
        int number = 0;

        System.out.println("Gramy w LOTTO! Podaj 6 liczb.");

        for (int i = 0; i < 6; i++) {
            System.out.println("Podaj liczbę nr " + (i + 1) + ":");
            counter = 0;
            while (counter == 0) {
                counter = 1;
                try {
                    while (((number = input.nextInt()) <= 0) || (49 < number)) {
                        System.out.println("Liczba musi mieścić się w przedziale od 1 do 49. Podaj liczbę nr " + (i + 1) + " jeszcze raz.");
                    }
                    if (ArrayUtils.contains(tab, number)) {
                        System.out.println("Już podałeś taką liczbę. Podaj inną liczbę.");
                        counter = 0;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Błędny format. Podaj liczbę nr " + (i + 1) + " jeszcze raz.");
                    input.next();
                    counter = 0;
                }
                tab[i] = number;
            }
        }
        input.close();
        Arrays.sort(tab);
        System.out.println(Arrays.toString(tab));


        for (int i = 0; i < 6; i++) {
            number = 0;
            while (ArrayUtils.contains(lotto, number)) {
                number = r.nextInt(49) + 1;
            }
            lotto[i] = number;
        }
        Arrays.sort(lotto);
        System.out.println(Arrays.toString(lotto));


        counter = 0;
        for (int i = 0; i < lotto.length; i++) {
            if (ArrayUtils.contains(lotto, tab[i])) {
                counter ++;
            }
        }


        switch (counter) {
            case 6:
                System.out.println("Trafiłeś szóstkę!!!");
                break;
            case 5:
                System.out.println("Trafiłeś piątkę!");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę!");
                break;
            case 3:
                System.out.println("Trafiłeś trójkę!");
                default:
                    System.out.println("Spróbuj szczęścia jeszcze raz");
        }
    }
}
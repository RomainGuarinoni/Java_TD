import java.util.Random;
import java.util.Scanner; // Import the Scanner class
import tp4.timersEtDialoguesTP4;

public class Escargot {
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static int throw_dice() {
        return getRandomNumberInRange(1, 6);
    }

    private static void simplified_run() {
        int escargot1 = 0;
        int escargot2 = 0;
        Boolean escargot1_can_start = false;
        Boolean escargot2_can_start = false;
        Boolean running = true;
        int i = 0;
        while (running) {
            if (escargot1_can_start) {
                escargot1 += throw_dice();
            }
            if (escargot2_can_start) {
                escargot2 += throw_dice();
            }
            if (throw_dice() == 6) {
                escargot1_can_start = true;
            }
            if (throw_dice() == 6) {
                escargot2_can_start = true;
            }
            if (escargot1 > 100 || escargot2 > 100) {
                running = false;
            }
            i++;
            System.out.println("Tour : " + i + "  /  e1 : " + escargot1 + " -  e2 : " + escargot2);
        }
    }

    private static int throw_dice_with_generator(int N) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = throw_dice();
        }
        return res;
    }

    private static void semi_simplified_run() {
        int escargot1 = 0;
        int escargot2 = 0;
        Boolean escargot1_can_start = false;
        Boolean escargot2_can_start = false;
        Boolean running = true;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (running) {
            System.out.println("Nombre de lancer escargot 1: ");
            int es1_number_throw = sc.nextInt();
            int escargot1_trow = throw_dice_with_generator(es1_number_throw);
            System.out.println("Nombre de lancer escargot 2: ");
            int es2_number_throw = sc.nextInt();
            int escargot2_trow = throw_dice_with_generator(es2_number_throw);
            if (escargot1_can_start) {
                escargot1 += escargot1_trow;
            }
            if (escargot2_can_start) {
                escargot2 += escargot2_trow;
            }
            if (escargot1_trow == 6) {
                escargot1_can_start = true;
            }
            if (escargot2_trow == 6) {
                escargot2_can_start = true;
            }
            if (escargot1 > 100 || escargot2 > 100) {
                running = false;
            }
            i++;
            System.out.println("Tour : " + i + "  /  e1 : " + escargot1 + " -  e2 : " + escargot2);
        }
    }

    public static void main(String[] args) {
        simplified_run();
        semi_simplified_run();
    }
}

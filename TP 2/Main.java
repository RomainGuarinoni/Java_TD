/**
 * Main
 */
public class Main {
    public static String leclerc(int N) {
        String res = "";
        for (int i = 1; i <= N; i++) {
            if (i % 5 == 0)
                res += "Fizz";
            else if (i % 7 == 0)
                res += "Buzz";
            else {
                res += Integer.toString(i);
            }
            res += " - ";
        }
        return res;
    }

    public static String line(int a, int b) {
        int calc = a * b;
        String aToString = Integer.toString(a);
        String bToString = Integer.toString(b);
        String calcToString = Integer.toString(calc);
        return aToString + " x " + bToString + " = " + calcToString;
    }

    public static String tableFor() {
        String res = "";
        for (int i = 1; i <= 10; i++) {
            res += "Tabble de multiplication du " + Integer.toString(i) + " :\n";
            for (int j = 1; j <= 10; j++) {
                res += line(i, j) + "\n";
            }
            res += "\n\n";
        }
        return res;
    }

    public static String tableWhile() {
        int i = 1;
        int j = 1;
        String res = "";
        while (i <= 10) {
            res += "Tabble de multiplication du " + Integer.toString(i) + " :\n";
            j = 1;
            while (j <= 10) {
                res += line(i, j) + "\n";
                j++;
            }
            res += "\n\n";
            i++;
        }
        return res;
    }

    public static String affichage() {
        // Les if sont uniquement là pour aligner
        String res = "     ";
        for (int i = 1; i <= 10; i++) {
            res += Integer.toString(i) + "    ";
        }
        res += "\n";

        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                res += Integer.toString(i) + "   ";
            } else {
                res += Integer.toString(i) + "    ";
            }
            for (int j = 1; j <= 10; j++) {
                if (i * j > 9) {
                    res += Integer.toString(i * j) + "   ";
                } else {
                    res += Integer.toString(i * j) + "    ";
                }
            }
            res += "\n";

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(leclerc(8));
        System.out.println(line(1, 1));
        System.out.println(tableFor());
        System.out.println(tableWhile());
        System.out.println(affichage());
    }
}
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

    public static String tableFor_new(int min, int max, int y) {
        String res = "";
        for (int i = 1; i <= y; i++) {
            res += "Tabble de multiplication du " + Integer.toString(i) + " :\n";
            for (int j = min; j <= max; j++) {
                res += line(i, j) + "\n";
            }
            res += "\n\n";
        }
        return res;
    }

    public static String tableWhile_new(int min, int max, int y) {
        int i = 1;
        int j = min;
        String res = "";
        while (i <= y) {
            res += "Tabble de multiplication du " + Integer.toString(i) + " :\n";
            j = min;
            while (j <= max) {
                res += line(i, j) + "\n";
                j++;
            }
            res += "\n\n";
            i++;
        }
        return res;
    }

    public static String affichage_new(int min, int max, int y) {
        // Les if sont uniquement là pour aligner
        String res = "     ";
        for (int i = min; i <= max; i++) {
            if (i > 9)
                res += Integer.toString(i) + "   ";
            else
                res += Integer.toString(i) + "    ";
        }
        res += "\n";

        for (int i = 1; i <= y; i++) {
            if (10 <= i && i < 100) {
                res += Integer.toString(i) + "   ";
            } else {
                res += Integer.toString(i) + "    ";
            }
            for (int j = min; j <= max; j++) {
                if (i * j > 999)
                    res += Integer.toString(i * j) + " ";
                else if (i * j > 99)
                    res += Integer.toString(i * j) + "  ";
                else if (i * j > 9)
                    res += Integer.toString(i * j) + "   ";
                else
                    res += Integer.toString(i * j) + "    ";

            }
            res += "\n";

        }
        return res;
    }

    public static String convert_to_letter(int n) {
        if (n == 10)
            return "A";
        else if (n == 11)
            return "B";
        else if (n == 12)
            return "C";
        else if (n == 13)
            return "D";
        else if (n == 14)
            return "E";
        else if (n == 15)
            return "F";
        return Integer.toString(n);
    }

    public static String decimal_to_hex(int n) {
        String res = "0x" + sub_decimal_to_hex(n);
        return res;
    }

    public static String decimal_to_hex_reversed(int n) {
        return "0x" + sub_decimal_to_hex_reversed(n, 10, false);
    }

    public static String sub_decimal_to_hex(int n) {
        if (n < 16) {
            return convert_to_letter(n);
        } else {
            return sub_decimal_to_hex(n / 16) + convert_to_letter(n % 16);
        }
    }

    public static String sub_decimal_to_hex_reversed(int n, int i, Boolean yes) {
        if (i == -1) {
            return "";
        }
        if ((n < Math.pow(16, i + 1) && n >= Math.pow(16, i))) {
            yes = true;
            return convert_to_letter((int) ((n - n % (Math.pow(16, i))) / (Math.pow(16, i))))
                    + sub_decimal_to_hex_reversed((int) (n - (n - n % (Math.pow(16, i)))), i - 1, yes);
        } else {
            if (n / Math.pow(16, i) < 1 && yes == true)
                return "0" + sub_decimal_to_hex_reversed((int) (n - (n - n % (Math.pow(16, i)))), i - 1, yes);
            else
                return sub_decimal_to_hex_reversed((int) (n - (n - n % (Math.pow(16, i)))), i - 1, yes);
        }
    }

    public static double piViete(double e, double res, double total) {
        if (Math.abs((2 / total) - Math.PI) > e) {
            total *= res;
            res = Math.sqrt(0.5 + 0.5 * res);
            return piViete(e, res, total);
        }
        return total;
    }

    public static double operateurFleche(int m, int k, int n) {
        if (k == 0) {
            return Math.pow(m, n);
        } else {
            return Math.pow(operateurFleche(m, k - 1, n), n);
        }
    }

    public static void hanoi(int n, String from, String temp, String to) {
        if (n == 0)
            return;
        hanoi(n - 1, from, to, temp);
        System.out.println("Bougez le disque " + n + " de " + from + " à " + to);
        hanoi(n - 1, temp, from, to);
    }

    public static void main(String[] args) {
        System.out.println(leclerc(8));
        System.out.println(line(1, 1));
        System.out.println(tableFor());
        System.out.println(tableWhile());
        System.out.println(affichage());
        System.out.println(tableFor_new(1, 10, 12));
        System.out.println(tableWhile_new(2, 3, 2));
        System.out.println(affichage_new(1, 10, 20));
        System.out.println(decimal_to_hex(257));
        System.out.println(decimal_to_hex_reversed(257));
        System.out.println(2 / piViete(0.001, Math.sqrt(0.5), 1));
        System.out.println(operateurFleche(3, 2, 3));
        int n = 42;
        hanoi(n, "A", "C", "B");
    }
}
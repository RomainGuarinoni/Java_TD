/**
 * Algorithme_de_Cesar
 */

public class Algorithme_de_Cesar {
    private static char ascii_to_char(int ascii) {
        return (char) ascii;
    }

    private static int char_to_ascii(char c) {
        return (int) c;
    }

    private static Boolean is_lowercase_letter(char c) {
        return char_to_ascii('a') <= char_to_ascii(c) && char_to_ascii(c) <= char_to_ascii('z');
    }

    private static Boolean is_uppercase_letter(char c) {
        return (char_to_ascii('A') <= char_to_ascii(c) && char_to_ascii('Z') >= char_to_ascii(c));
    }

    private static char char_shift(char c, int shift, int direction) {
        /*
         * c : char you want to shift // shift : integer // direction : -1 or 1 for
         * direction
         */
        int ascii;
        if (is_lowercase_letter(c)) {
            ascii = char_to_ascii(c) + shift * direction;
            if (!is_lowercase_letter(ascii_to_char(ascii))) {
                ascii = ascii + direction * 26 * -1;
            }
            return ascii_to_char(ascii);
        } else if (is_uppercase_letter(c)) {
            ascii = char_to_ascii(c) + shift * direction;
            if (!is_uppercase_letter(ascii_to_char(ascii))) {
                ascii = ascii + direction * 26 * -1;
            }
            return ascii_to_char(ascii);
        } else {
            return ' ';
        }
    }

    public static String algo_cesar(String str, int shift, int direction) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res += char_shift(c, shift, direction);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Conversion de : Bonjour ceci est un test !!");
        System.out.println(algo_cesar("Bonjour ceci est un test !!", 2, 1));
        System.out.println("Dans l'autre sens maintenant");
        System.out.println(algo_cesar("Dqplqwt egek guv wp vguv", 2, -1));
    }
}
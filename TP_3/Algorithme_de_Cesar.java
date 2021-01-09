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

    public static void main(String[] args) {
        System.out.println(char_shift('z', 1, 1));
        System.out.println(char_shift('f', 13, -1));
    }
}
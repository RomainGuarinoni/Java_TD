/**
 * Algorithme_de_Vigenere
 */
public class Algorithme_de_Vigenere {
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

    private static int get_relative_index(char c) {
        char c_lowercase = Character.toLowerCase(c);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.indexOf(c_lowercase);
    }

    public static String algo_vigenere(String str, String key, int direction) {
        String res = "";
        String alphabet_lowercase = "abcdefghijklmnopqrstuvwxyz";
        String alphabet_uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int key_length = key.length();
        for (int i = 0; i < str.length(); i++) {
            char str_char = str.charAt(i);
            char key_char = key.charAt(i % key_length);
            int str_index = get_relative_index(str_char);
            int key_index = get_relative_index(key_char);
            int shift = (str_index + key_index * direction) % 26;
            System.out.println(str_index);
            System.out.println(key_index);
            System.out.println(shift + "\n");
            if (Character.isUpperCase(str_char)) {
                res += alphabet_uppercase.charAt(shift);
            } else {
                res += alphabet_lowercase.charAt(shift);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(algo_vigenere("PROGRAMMATION", "LINUX", 1));
        // System.out.println(algo_vigenere("AZBAOLUZUQTWA", "LINUX", -1));
    }
}
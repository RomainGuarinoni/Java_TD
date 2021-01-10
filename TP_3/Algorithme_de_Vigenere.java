/**
 * Algorithme_de_Vigenere
 */
public class Algorithme_de_Vigenere {
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
            int shift = (str_index + key_index * direction);
            if (shift < 0) {
                shift += 26;
            }
            int new_letter_index = shift % 26;
            if (Character.isUpperCase(str_char)) {
                res += alphabet_uppercase.charAt(new_letter_index);
            } else {
                res += alphabet_lowercase.charAt(new_letter_index);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(algo_vigenere("PROGRAMMATION", "LINUX", 1));
        System.out.println(algo_vigenere("AZBAOLUZUQTWA", "LINUX", -1));
    }
}
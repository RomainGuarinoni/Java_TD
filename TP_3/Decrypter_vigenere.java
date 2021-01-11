import java.io.CharArrayReader;
import GestionDesFichiers.GestionDesFichiers;

public class Decrypter_vigenere {
    private static int char_to_ascii(char c) {
        return (int) c;
    }

    private static Boolean is_lowercase_letter(char c) {
        return char_to_ascii('a') <= char_to_ascii(c) && char_to_ascii(c) <= char_to_ascii('z');
    }

    private static Boolean is_uppercase_letter(char c) {
        return (char_to_ascii('A') <= char_to_ascii(c) && char_to_ascii('Z') >= char_to_ascii(c));
    }

    private static String[] subtext(String str, int p) {
        String[] res = new String[p];
        for (int q = 0; q < p; q++) {
            String sub_res = "";
            for (int k = 0; k * p + q < str.length(); k++) {
                char c = str.charAt(k * p + q);
                sub_res += c;
            }
            res[q] = sub_res;
        }
        return res;
    }

    private static String get_letters_only(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (is_uppercase_letter(c) || is_lowercase_letter(c)) {
                res += c;
            }
        }
        return res;
    }

    private static int get_relative_index(char c) {
        char c_lowercase = Character.toLowerCase(c);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.indexOf(c_lowercase);
    }

    private static int[] count_subtext_letters(String str) {
        int[] res = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res[get_relative_index(c)] += 1;
        }
        return res;
    }

    private static void display_string_arr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            display_int_arr(count_subtext_letters(arr[i]));
            System.out.println(indice_de_coincidence(arr[i]));
        }
    }

    private static void display_int_arr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // System.out.println("");
    }

    private static double indice_de_coincidence(String str) {
        int[] count_letters = count_subtext_letters(str);
        double res = 0;
        for (int i = 0; i < 26; i++) {
            res += ((double) count_letters[i] * ((double) count_letters[i] - 1))
                    / ((double) str.length() * ((double) str.length() - 1));
        }
        return res;
    }

    private static double indice_coincidence_total(String[] str_arr, int p) {
        double res = 0;
        for (int i = 0; i < str_arr.length; i++) {
            res += indice_de_coincidence(str_arr[i]);
        }
        return res / p;
    }

    public static void main(String[] args) {
        GestionDesFichiers f = new GestionDesFichiers("./textes/ActualiteMinesDouaiVigenere.txt");
        String s = f.lireFichierTexte();
        // System.out.println(s);
        String letteronly = get_letters_only(s);
        //

        double min = 1000;
        double diff = 1000;
        int minindex = 0;
        for (int p = 1; p < s.length() / 3; p++) {
            String[] subtext_var = subtext(letteronly, p);
            // display_string_arr(subtext_var);
            if (letteronly.length() / p < 33) {
                double coincide = indice_coincidence_total(subtext_var, p);
                if (Math.abs(coincide - 0.0745) < diff) {
                    diff = Math.abs(coincide - 0.0745);
                    min = coincide;
                    minindex = p;
                }
                System.out.println(p + "  total : " + coincide + " " + letteronly.length() / p);
            }
        }
        System.out.println(min + " " + minindex + " diff  " + diff);

        // on a pas réussi mais on le faire avec ce site :
        // https://www.apprendre-en-ligne.net/crypto/vigenere/decryptauto.html

        // on s'est trompé sur l'indice p qui devait être la taille de la clef. Dans
        // notre cas
        // on a pris p comme le nombre de sous textes ... Au final on a pas réussi dans
        // le temps
        // imparti

        // Après on a quand même réussi césar et à lire le fichier grâce à la
        // compilation et exécution
        // avec le flag -classpath. (voir le makefile)
    }
}

import GestionDesFichiers.GestionDesFichiers;
import java.util.Arrays;

public class Decrypter {
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

    private static Boolean is_a_letter(char c) {
        return is_lowercase_letter(c) || is_uppercase_letter(c);
    }

    private static int get_relative_index(char c) {
        char c_lowercase = Character.toLowerCase(c);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.indexOf(c_lowercase);
    }

    private static char get_letter_from_index(int index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.charAt(index);
    }

    private static double[] divide_array(double[] arr, double divider) {
        double[] res = arr;
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i] / divider;
        }
        return res;
    }

    private static double[] apparition_frequency(String sentences) {
        double[] res = new double[26];
        Arrays.fill(res, 0);

        for (int i = 0; i < sentences.length(); i++) {
            char c = sentences.charAt(i);
            if (is_a_letter(c)) {
                int letter_alphabet_index = get_relative_index(c);
                res[letter_alphabet_index] += 1;
            }
        }

        return divide_array(res, 26.0);
    }

    private static void print_array(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    private static double sum_in_array(double[] arr) {
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }

    private static double[] substract_arrays_square(double[] A, double[] B) {
        double[] res = new double[26];
        for (int i = 0; i < A.length; i++) {
            res[i] = Math.pow(A[i] - B[i], 2);
        }
        return res;
    }

    private static double[] shift_array(int shift, double[] arr) {
        double[] res = new double[26];
        for (int i = 0; i < arr.length; i++) {
            if (i + shift >= 26) {
                res[i] = arr[i + shift - 26];
            } else {
                res[i] = arr[i + shift];
            }
        }
        return res;
    }

    private static char find_key(double[] frequency_arr) {
        final double[] reference_frequency = { 7.97, 1.07, 3.47, 4, 17.9, 1.01, 1.04, 1.35, 7.34, 0.3, 0.069, 5.48,
                3.17, 7.02, 5.27, 2.8, 1.13, 6.64, 7.72, 7.28, 5.74, 1.17, 0.059, 0.449, 0.309, 0.04 };
        double min_value = 1000;
        int min_index = 0;
        for (int i = 0; i < frequency_arr.length; i++) {
            double[] difference_array = substract_arrays_square(reference_frequency, shift_array(i, frequency_arr));
            double difference_sum = sum_in_array(difference_array);
            if (difference_sum < min_value) {
                min_value = difference_sum;
                min_index = i;
            }
        }
        char res = get_letter_from_index(min_index);
        return res;
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
        GestionDesFichiers f = new GestionDesFichiers("./textes/ActualiteMinesDouaiCesar.txt");
        String s = f.lireFichierTexte();
        double[] frequency_arr = apparition_frequency(s);
        char key = find_key(frequency_arr);
        System.out.println(s);
        System.out.println("The encoding key is probably : " + find_key(frequency_arr) + "\n\n");
        System.out.println(algo_cesar(s, get_relative_index(key), -1));
    }
}

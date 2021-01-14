import java.util.Random;

public class FIPS {

    private static int[] generateDatset(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = getRandomNumberInRange(0, 1);
        }
        return res;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static void diplay_int_array(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
    }

    private static void head_int_array(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("] Total length : " + arr.length);
    }

    private static Boolean monobit_test(int[] arr) {
        int number_of_true = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                number_of_true++;
            }
        }
        if (9654 < number_of_true && number_of_true < 10346) {
            return true;
        }
        return false;
    }

    private static int binary_to_decimal(String bin) {
        return Integer.parseInt(bin, 2);
    }

    private static int array_square_sum(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] * arr[i];
        }
        return res;
    }

    private static Boolean poker_test(int[] arr) {
        int[] nombre_occurence = new int[16];
        for (int i = 0; i < arr.length; i += 4) {
            String bin = "";
            for (int j = 0; j < 4; j++) {
                bin += arr[i + j];
            }
            nombre_occurence[binary_to_decimal(bin)]++;
        }

        double X = ((16.0 / 5000.0) * array_square_sum(nombre_occurence)) - 5000;
        if (1.03 < X && X < 57.4) {
            return true;
        }
        return false;

    }

    private static Boolean notBetween(int value, int a, int b) {
        return a > value || value > b;
    }

    private static Boolean run_test(int[] arr) {
        Boolean res = true;
        int[] nombre_occurence = new int[7];
        int[] test_array = { 2267, 2733, 1079, 1421, 502, 748, 223, 402, 90, 223, 90, 223 };
        int counter = 1;
        int value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == value) {
                counter++;
            } else {
                if (counter > 6) {
                    nombre_occurence[6]++;
                } else {
                    nombre_occurence[counter]++;
                }
                counter = 0;
                if (value == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
            }
        }
        for (int i = 1, j = 0; i < 7; i++, j += 2) {
            if (notBetween(nombre_occurence[i], test_array[j], test_array[j + 1])) {
                res = false;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] dataset = generateDatset(20000);
        head_int_array(dataset);
        System.out.println("test monobit : " + monobit_test(dataset));
        System.out.println("test poker : " + poker_test(dataset));
        System.out.println("test run : " + run_test(dataset));
    }
}
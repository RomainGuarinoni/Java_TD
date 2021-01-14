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

    public static void main(String[] args) {
        int[] dataset = generateDatset(20000);
        head_int_array(dataset);
        System.out.println("test monobit : " + monobit_test(dataset));
        System.out.println("test poker : " + poker_test(dataset));
    }
}
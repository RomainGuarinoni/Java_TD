public class Main {
    private static void printArray(double[] arr) {
        if (!array_is_only_zero(arr)) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    private static Boolean array_is_only_zero(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Les valeurs que j'utilise sont celles de l'énoncé.
        double[] arr_method_1 = { 0.86, 0.81, 0.47, 0.97, 0.23, 0.62, 0.43, 0.67, 0.45, 0.17, 0.15, 0.90, 0.73, 0.04,
                0.63, 0.35 };
        double[] arr_method_2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Signal s1 = new Signal(4, arr_method_1);
        Signal s2 = new Signal(4, arr_method_2);
        System.out.println("Methode 1 ------------ \n\n");
        printArray(s1.sub_sampling(2)); // Quand on rentre 2Hz ça marche
        printArray(s1.sub_sampling(3)); // Si on rentre 3Hz ça ne marche pas !
        System.out.println("\n\nMethode 2 ------------ \n\n");
        printArray(s2.filtered_signal(1));
        System.out.println("\n\nMethode correlation ------------ \n\n");
        double[] arr_method_3 = { 1, 2, 4, 4, 5, 1, 7, 8 };
        System.out.println("coef de correlation entre s3 et s2  :  " + s2.coef_correlation(arr_method_3));
        System.out.println("réponse pour deux signaux de taille diff : " + s2.coef_correlation(arr_method_1));
    }
}

public class Test {
    public static void main(String[] args) {
        float[] tab = new float[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        float[] tab2 = new float[] { 2, 4, 5, 8, 6, 7, 4, 4 };
        Signal signal = new Signal(4, tab);
        signal.average_filter(3);
        for (int i = 0; i < signal.tab.length; i++) {
            System.out.println(signal.tab[i]);
        }

        System.out.println("Le coefficient de correlation des deux signaux est " + signal.correlation(tab2));

    }
}
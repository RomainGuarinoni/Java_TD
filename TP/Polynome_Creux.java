import java.util.Scanner;

public class Polynome_Creux {
    double[][] polynome = new double[50][2];
    int nbCoefs;

    public Polynome_Creux() {
        nbCoefs = readCoefs();
        System.out.println();
        for (int i = 0; i < nbCoefs; i++) {
            System.out.print("Rentrez un exposant: ");
            polynome[i][0] = readDouble();
            System.out.print("Rentrez un coef: ");
            polynome[i][1] = readDouble();
        }
    }

    public void print() {
        for (int i = 0; i < nbCoefs; i++) {
            System.out.print(polynome[i][0] + "  ");
        }
        System.out.println();
        for (int i = 0; i < nbCoefs; i++) {
            System.out.print(polynome[i][1] + "  ");
        }
    }

    private int readCoefs() {
        System.out.print("Rentrez le nombre de coefs : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private double readDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

}

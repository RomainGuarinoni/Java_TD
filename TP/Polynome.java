import java.util.Scanner;

public class Polynome {
    private int degre;
    private double[] coefs = new double[50];

    public Polynome() {
        this.degre = read_degre();
        read_coefs();
    }

    private int read_degre() {
        System.out.print("Rentrez le degré du polynome : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private double read_double() {
        System.out.print("Veuillez saisir un coefficient : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private void read_coefs() {
        System.out.println("Il faut rentrer des nombres avec des virgules et pas des points");
        for (int i = 0; i < this.degre; i++) {
            this.coefs[i] = read_double();
        }
    }

    public String toString() {
        String res = "";
        for (int i = degre - 1; i >= 0; i--) {
            res += this.coefs[i];
            if (i != 0) {
                if (i == 1) {
                    res += " X " + "+ ";
                } else {
                    res += "X^" + i + " + ";
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Polynome p = new Polynome();
        System.out.println(p);
    }
}
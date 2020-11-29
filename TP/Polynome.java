import java.util.Scanner;

public class Polynome {
    private int degre;
    private double[] coefs = new double[50];

    public Polynome() {
        this.degre = readDegre();
        readCoefs();
    }

    public Polynome(int degre, double[] coefs) {
        this.degre = degre;
        this.coefs = coefs;
    }

    private int readDegre() {
        System.out.print("Rentrez le degré du polynome : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private double readDouble() {
        System.out.print("Veuillez saisir un coefficient : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private void readCoefs() {
        System.out.println("Il faut rentrer des nombres avec des virgules et pas des points");
        for (int i = 0; i < this.degre; i++) {
            this.coefs[i] = readDouble();
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

    public double evalPolynome(double X) {
        double res = 0;
        for (int i = degre - 1; i >= 0; i--) {
            if (degre == 0) {
                res += this.coefs[i];
            } else {
                res += this.coefs[i] * Math.pow(X, i);
            }
        }
        return res;
    }

    public double evalPolynomeRec(double X, int degre) {
        if (degre == 0) {
            return this.coefs[0];
        } else {
            return this.coefs[degre] * Math.pow(X, degre) + evalPolynomeRec(X, degre - 1);
        }
    }

    public Polynome additionPolynome(Polynome P, Polynome Q) {
        int degre;
        if (P.degre > Q.degre)
            degre = P.degre;
        else
            degre = Q.degre;
        double[] coefs = new double[degre];
        for (int i = 0; i < degre; i++) {
            coefs[i] = P.coefs[i] + Q.coefs[i];
        }
        return new Polynome(degre, coefs);

    }

    public Polynome produitExterne(double scalaire) {
        double[] coefs = new double[this.degre];
        for (int i = 0; i < this.degre; i++) {
            coefs[i] = scalaire * this.coefs[i];
        }
        return new Polynome(this.degre, coefs);
    }

    public static void main(String[] args) {
        Polynome p = new Polynome();
        System.out.println(p);
        System.out.println(p.evalPolynome(2));
        System.out.println(p.evalPolynomeRec(2, p.degre - 1));
        /*
         * Polynome q = new Polynome(); System.out.println(q); Polynome res =
         * q.additionPolynome(p, q); System.out.println(res);
         */
        System.out.println(p.produitExterne(2));
    }
}
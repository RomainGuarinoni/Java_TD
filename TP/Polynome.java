import java.util.Scanner;

public class Polynome {
    private int degre;
    private double[] coefs = new double[50];

    public Polynome() {
        this.degre = readDegre();
        this.degre += 1; // Quickfix parce que je sais pas coder
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

    private double[] popFirstValue(double[] arr) {
        double[] res = new double[arr.length];
        for (int i = 1; i < arr.length; i++) {
            res[i - 1] = arr[i];
        }
        return res;
    }

    private double abs(double number) {
        if (number > 0) {
            return number;
        } else {
            return -1 * number;
        }
    }

    public int get_degre() {
        return this.degre;
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
            res += this.coefs[i] * Math.pow(X, i);
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
        double[] res;
        if (P.degre > Q.degre) {
            res = P.coefs;
            for (int i = 0; i < Q.degre; i++) {
                res[i] = P.coefs[i] + Q.coefs[i];
            }
        } else {
            res = Q.coefs;
            for (int i = 0; i < P.degre; i++) {
                res[i] = P.coefs[i] + Q.coefs[i];
            }
        }
        return new Polynome(degre, res);

    }

    public Polynome produitExterne(double scalaire, Polynome P) {
        double[] coefs = new double[this.degre];
        for (int i = 0; i < P.degre; i++) {
            coefs[i] = scalaire * P.coefs[i];
        }
        return new Polynome(P.degre, coefs);
    }

    public Polynome derivPolynome(Polynome P) {
        double res[] = new double[P.degre];
        for (int i = 0; i < P.degre; i++) {
            res[i] = P.coefs[i] * i;
        }
        res = popFirstValue(res);
        return new Polynome(P.degre - 1, res);
    }

    public Polynome primitivePolynome(Polynome P) {
        double[] res = new double[P.degre + 1];
        for (int i = 0; i < P.degre; i++) {
            res[i] = P.coefs[i] / (i + 1);
        }
        for (int i = P.degre; i > 0; i--) {
            res[i] = res[i - 1];
        }
        res[0] = 0;
        return new Polynome(P.degre + 1, res);
    }

    public Polynome produitInterne(Polynome P, Polynome Q) {
        int nouveauDegre = P.degre + Q.degre - 1; // C'est encore à cause de mon code bancale le -1
        Polynome res = new Polynome(nouveauDegre, new double[nouveauDegre]);
        for (int i = 0; i < P.degre; i++) {
            for (int j = 0; j < Q.degre; j++) {
                res.coefs[i + j] += P.coefs[i] * Q.coefs[j];
            }
        }
        return res;
    }

    public double[] rechercheZeroDicho(double a, double b, double e, Polynome P) {
        while (b - a > e) {
            double m = (a + b) / 2;
            if (P.evalPolynome(a) * P.evalPolynome(m) <= 0) {
                b = m;
            } else {
                a = m;
            }
        }
        return new double[] { a, b };
    }

    public double rechercheZeroNewton(double a, double e, Polynome P) {
        double f = P.evalPolynome(a);
        Polynome dPoly = P.derivPolynome(P);
        double df = dPoly.evalPolynome(a);
        while ((abs(f / df) > e)) {
            a = a - (f / df);
            f = P.evalPolynome(a);
            df = dPoly.evalPolynome(a);
        }
        return a;
    }

    public Polynome[] genTableauPoly(int nbPolynome) {
        Polynome[] res = new Polynome[nbPolynome];
        for (int i = 0; i < nbPolynome; i++) {
            res[i] = new Polynome();
        }
        return res;
    }

    public void printTableauPoly(Polynome[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public Polynome sommeTableauP(Polynome[] arr) {
        Polynome res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = arr[0].additionPolynome(res, arr[i]);
        }
        return res;
    }

    public Polynome produitInterneTableauP(Polynome[] arr) {
        Polynome res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = arr[0].produitInterne(res, arr[i]);
        }
        return res;
    }

}
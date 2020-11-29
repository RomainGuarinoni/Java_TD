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

    public Polynome produitExterne(double scalaire, Polynome P) {
        double[] coefs = new double[this.degre];
        for (int i = 0; i < P.degre; i++) {
            coefs[i] = scalaire * P.coefs[i];
        }
        return new Polynome(P.degre, coefs);
    }

    public Polynome derivPolynome(Polynome P) {
        Polynome res = new Polynome(P.degre, P.coefs);
        for (int i = 0; i < P.degre; i++) {
            res.coefs[i] = res.coefs[i] * i;
        }
        res.coefs = popFirstValue(res.coefs);
        res.degre -= 1;
        return res;
    }

    public Polynome primitivePolynome(Polynome P) {
        Polynome res = new Polynome(P.degre, P.coefs);
        for (int i = 0; i < P.degre; i++) {
            res.coefs[i] = coefs[i] / (i + 1);
        }
        res.degre += 1;
        for (int i = degre; i > 0; i--) {
            res.coefs[i] = res.coefs[i - 1];
        }
        res.coefs[0] = 0;
        return res;
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

    // Je peux pas faire Newton parce que faut faire des division et je sais pas
    // comment faire. Par contre faut aussi solve le pb des zeros pour le degre
    // des polynomes.

    public static void main(String[] args) {
        Polynome p = new Polynome();
        System.out.println(p);
        /*
         * Polynome q = new Polynome(); System.out.println(q);
         * System.out.println(p.evalPolynome(2));
         * System.out.println(p.evalPolynomeRec(2, p.degre - 1)); Polynome q = new
         * Polynome(); System.out.println(q); Polynome res = q.additionPolynome(p, q);
         * System.out.println(res); System.out.println(p.produitExterne(2, p));
         * System.out.println(p.derivPolynome(p));
         * System.out.println(p.primitivePolynome(p));
         * 
         * Polynome n = p.produitInterne(p, q); System.out.println(n);
         * System.out.println(p.rechercheZeroDicho(-2, 1, 0.001, p)[0]); // avec
         * -1x^2+4x+2
         */
        Polynome t[] = p.genTableauPoly(3);
        p.printTableauPoly(t);

    }

}
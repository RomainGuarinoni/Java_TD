public class Question_10 {
    public static void main(String[] args) {
        double[] coefs = { 2, 4, -1 };
        int degre = 3;
        Polynome p = new Polynome(degre, coefs);
        System.out.println(p);
        double[] resDicho = p.rechercheZeroDicho(-2, 1, 0.001, p);
        System.out.println(resDicho[0] + "  |  " + resDicho[1]);
        System.out.println(p.rechercheZeroNewton(-2, 0.001, p));
    }
}
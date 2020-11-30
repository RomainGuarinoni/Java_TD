public class Question_9 {
    public static void main(String[] args) {
        double[] coefs = { 2, 2, 2 };
        int degre = 3;
        Polynome p = new Polynome(degre, coefs);
        double[] coefs_b = { 2, 3 };
        int degre_b = 2;
        Polynome q = new Polynome(degre_b, coefs_b);
        System.out.println(p);
        System.out.println(q);
        System.out.println(p.additionPolynome(p, q));
    }
}

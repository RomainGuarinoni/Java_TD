public class Question_7 {
    public static void main(String[] args) {
        double[] coefs = { 2, 2, 2 };
        int degre = 3;
        Polynome p = new Polynome(degre, coefs);
        System.out.println(p);
        System.out.println(p.derivPolynome(p));
    }
}

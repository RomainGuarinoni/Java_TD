public class Question_11 {
    public static void main(String[] args) {
        Polynome p = new Polynome(1, new double[] { 1 });
        Polynome t[] = p.genTableauPoly(3);
        p.printTableauPoly(t);
        System.out.println(p.sommeTableauP(t));
        System.out.println(p.produitInterneTableauP(t));
    }
}

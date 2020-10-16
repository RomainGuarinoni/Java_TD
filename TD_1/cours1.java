//premier test avec cours
import java.util.ArrayList;

//import org.graalvm.compiler.core.amd64.AMD64ArithmeticLIRGenerator.Maths;
class exercice_2 {
    public static int puissance(int x, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    public static int sommeTableau(int[] tab) {
        int somme = 0;
        for (int i = 0; i < tab.length; i++) {
            somme += tab[i];
        }
        return somme;
    }
    public static void nombrePremier(int n){
        
        
        ArrayList<Integer> entier= new ArrayList<Integer>();
        ArrayList<Integer> premier= new ArrayList<Integer>(); 
        int element=2; 
        for(int i=0;i<n-1;i++){ // création du tableau d'entier jusqu'à n
            entier.add(element);
            element+=1;
        }
        int index=0;
        while(!entier.isEmpty()){
            int valeur=entier.get(0);
            premier.add(valeur);
            entier.remove(0);
            while(index<entier.size()){
                if (entier.get(index)%valeur==0){
                    entier.remove(index);
                }
                else{
                    index+=1;
                }
            }
        index=0;
        }
        System.out.println(premier);
    }
    
    
    public static void main(String[] args) {
        int x = 3;
        int n = 4;
        int res = puissance(x, n);
        System.out.println("la valeur de " + x + " a la puissance " + n + " est " + res);
        int tab[] = { 1, 2, 32, 4 };
        System.out.println(sommeTableau(tab));
       nombrePremier(200);
       System.out.println("bonjour");
       System.out.println(Math.sqrt(50));
    }

}

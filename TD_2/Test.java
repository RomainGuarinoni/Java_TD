public class Test {
    public static void main(String[] args) {
        float[] tab=new float[]{1,2,3,4,5,6,7,8};
       Signal couille=new Signal (4,tab);
       couille.average_filter(3);
       for(int i=0;i<couille.tab.length;i++){
           System.out.println(couille.tab[i]);
       }
    }
}
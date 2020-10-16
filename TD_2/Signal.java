public class Signal { // coucou alex

    public float[] tab;
    private int frequence; // Je choisis (int) pcq sinon ca me casse les signals
    private int duration;

    // Les trois fonctions constructeurs de la classe
    public Signal() {
        this.tab = new float[1000];
        this.frequence = 1000;
    }

    public Signal(int frequence, int duration) {
        this.frequence = is_pos_frequence(frequence);
        this.duration = is_pos_duration(duration);
        this.tab = new float[((int) this.frequence * (int) this.duration)];
    }

    public Signal(int frequence, float signal[]) {
        this.frequence = is_pos_frequence(frequence);
        this.tab = signal;
    }

    public static int is_pos_frequence(int frequence) {
        if (frequence >= 0) {
            return frequence;
        } else {
            return 0;
        }
    }

    public static int is_pos_duration(int duration) {
        if (duration >= 0) {
            return duration;
        } else {
            return 0;
        }
    }

    public void sub_sampling(int frequence) { // fonction qui sub divise le signal de base par une sous fréquence
                                              // donnée.
        if (this.frequence % frequence != 0) {
            this.tab = new float[frequence * (int) this.duration];
        } else {
            float[] sub_tab = new float[(this.tab).length / frequence];
            for (int i = 0, j = 0 ; i < (this.tab).length; i = i + frequence, j++) {
                sub_tab[j] = this.tab[i];
            }
            this.tab = sub_tab;
        }

    }

    // variables: "i":le point considéré "n": Le nombre de points a prendre autour
    public void average_filter(int n) { // fonction qui transforme un point en la moyenne des "n" points autour de lui.
        float[] tab_aux = new float[this.tab.length];
        for (int i = 0; i < this.tab.length; i++) { // boucle qui parcourt chaque point du tableau
            tab_aux[i] = (sum_right(n, this.tab, i) + sum_left(n, this.tab, i)) / (2 * n + 1);
        }
        this.tab = tab_aux;
    }

    public float sum_right(int n, float[] tab, int i) {
        float somme = 0;
        for(int j=0;j<=n;j++){
            if(j+i<tab.length){
                somme+=tab[j+i];
            }
            else{
                somme+=tab[tab.length-1];
            }
        }
        return somme;
    }

    public float sum_left(int n, float[] tab, int i) {
        float somme = 0;
        for(int j=1;j<=n;j++){
            if(i-j>=0){
                somme+=tab[i-j];
            }
            else{
                somme+=tab[0];

            }
        }
        return somme;
    }
}

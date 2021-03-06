// Bonjour bienvenue sur le Fast Fourier Tranform for discrete value badabim badaboum j'adore l'algorithmique (c'est faux aled mon cerveau fond :^)     ) 
public class FFT {
    public Complexe[] fft(Complexe[] signal) {
        int N = signal.length;

        // condition d'arrêt
        if (N == 1)
            return new Complexe[] { signal[0] };
        if (N % 2 != 0) {
            throw new RuntimeException("N n'est pas une puissance de 2");
        }
        // on crée un nouveau tableau pour les éléments pairs
        Complexe[] pair = new Complexe[N / 2];
        for (int k = 0; k < N / 2; k++) {
            pair[k] = signal[2 * k];
        }
        Complexe[] q = fft(pair);

        Complexe[] impair = pair; // on fait du recyclage en réutilisant l'ancien tableau. on est pas écolo nous
                                  // (kill me please)
        for (int k = 0; k < N / 2; k++) {
            impair[k] = signal[2 * k + 1];
        }
        Complexe[] r = fft(impair);

        Complexe y[] = new Complexe[N];
        for (int k = 0; k < N / 2; k++) {
            double kth = -2 * k * Math.PI;
            Complexe wk = new Complexe(Math.cos(kth), Math.sin(kth));
            y[k] = q[k].sum(wk.mul(r[k]));
            y[k + N / 2] = q[k].minus(wk.mul(r[k]));
        }
        return y;
    }
}

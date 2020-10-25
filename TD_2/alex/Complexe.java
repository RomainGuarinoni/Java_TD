public class Complexe {
    double re;
    double im;

    public Complexe(double partie_reel, double partie_im) {
        this.re = partie_reel;
        this.im = partie_im;
    }

    public Complexe() {
        this.re = 0;
        this.im = 0;
    }

    public Complexe sum(Complexe c) {
        double new_re = this.re + c.re;
        double new_im = this.im + c.im;
        return new Complexe(new_re, new_im);
    }

    public Complexe minus(Complexe c) {
        double new_re = this.re - c.re;
        double new_im = this.im - c.im;
        return new Complexe(new_re, new_im);
    }

    public Complexe mul(Complexe c) {
        double new_re = this.re * c.re - this.im * c.im;
        double new_im = this.re * c.im + this.im * c.re;
        return new Complexe(new_re, new_im);
    }

    public Complexe[] convert_to_complexe(double[] arr) {
        Complexe[] res = new Complexe[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = new Complexe(arr[i], 0);
        }
        return res;
    }

    public Complexe[] init_empty(int length) {
        Complexe[] res = new Complexe[length];
        for (int i = 0; i < length; i++) {
            res[i] = new Complexe(0, 0);
        }
        return res;
    }

    public void print(Complexe c) {
        System.out.println(c.re + "+" + "i" + c.im);
    }
}

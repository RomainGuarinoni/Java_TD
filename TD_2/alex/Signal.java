public class Signal {
    private double[] signal_values;
    private double frequency;

    public Signal() {
        this.signal_values = new double[1000];
        frequency = 1000;
    }

    public Signal(double frequency, double duration) {
        frequency = make_positive(frequency);
        duration = make_positive(duration);
        this.signal_values = new double[(int) frequency * (int) duration];
        this.frequency = frequency;
    }

    public Signal(double frequency, double[] signal_values) {
        this.signal_values = signal_values;
        this.frequency = make_positive(frequency);
    }

    private double make_positive(double n) {
        if (n < 0) {
            return n * -1;
        }
        return n;
    }

    public double[] sub_sampling(double new_frequency) {
        double duration = this.signal_values.length;
        if (sub_sampling_frequency_not_correct(new_frequency)) {
            System.out.println("\n\nNouvelle fréquence " + new_frequency + " incorrecte !");
            return new double[(int) this.frequency * (int) duration];
        }

        int N = (int) this.frequency / (int) new_frequency;
        double[] sub_sampled_values = new double[this.signal_values.length / N];
        for (int i = 0, j = 0; j < this.signal_values.length; i++, j += N) {
            sub_sampled_values[i] = this.signal_values[j];
        }
        return sub_sampled_values;
    }

    private Boolean sub_sampling_frequency_not_correct(double new_frequency) {
        return !((this.frequency % new_frequency) == 0);
    }

    public double[] filtered_signal(int n) {
        double[] filtered_signal_array = new double[this.signal_values.length];
        for (int i = 0; i < this.signal_values.length; i++) {
            double filtered_value = left_sum(this.signal_values, i - 1, n - 1) + this.signal_values[i]
                    + right_sum(this.signal_values, i + 1, n - 1);
            filtered_value = filtered_value / (2 * n + 1);
            filtered_signal_array[i] = filtered_value;
        }
        return filtered_signal_array;
    }

    private double left_sum(double[] arr, int index, int n) {
        if (n == 0) {
            if (index < 0)
                return arr[0];
            return arr[index];
        } else if (index < 0)
            return left_sum(arr, index - 1, n - 1) + arr[0];
        else
            return left_sum(arr, index - 1, n - 1) + arr[index];
    }

    private double right_sum(double[] arr, int index, int n) {
        if (n == 0) {
            if (index >= arr.length)
                return arr[arr.length - 1];
            return arr[index];
        } else if (index >= arr.length)
            return right_sum(arr, index + 1, n - 1) + arr[arr.length - 1];
        else
            return right_sum(arr, index + 1, n - 1) + arr[index];
    }

    private double signal_mean(double[] arr) {
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res / arr.length;
    }

    private double sum_value_and_mean(double[] signal1, double[] signal2) {
        double signal1_mean = signal_mean(signal1);
        double signal2_mean = signal_mean(signal2);
        double res = 0;
        for (int i = 1; i < signal1.length; i++) {
            res += (signal1[i] - signal1_mean) * (signal2[i] - signal2_mean);
        }
        return res;

    }

    public double coef_correlation(double[] signal) {
        if (signal.length != this.signal_values.length) {
            System.out.println("Les deux signaux n'ont pas la même taille :  " + signal.length + "  et  "
                    + this.signal_values.length);
            return -1;
        }
        return sum_value_and_mean(this.signal_values, signal)
                / (Math.sqrt(sum_value_and_mean(this.signal_values, this.signal_values))
                        * Math.sqrt(sum_value_and_mean(signal, signal)));
    }
}
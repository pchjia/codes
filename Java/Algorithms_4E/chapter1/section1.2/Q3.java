public class Q3 {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] intervals = new Interval2D[N];

        for (int i=0; i<N; i++) {
            double[] vals = new double[4];
            vals[0] = StdRandom.uniform(min, max);
            vals[1] = StdRandom.uniform(min, max);
            vals[2] = StdRandom.uniform(min, max);
            vals[3] = StdRandom.uniform(min, max);

            if (vals[0] > vals[1]) {
                double val = vals[0];
                vals[0] = vals[1];
                vals[1] = val;
            }

            if (vals[2] > vals[3]) {
                double val = vals[2];
                vals[2] = vals[3];
                vals[3] = val;
            }
            
            Interval1D x = new Interval1D(vals[0], vals[1]);
            Interval1D y = new Interval1D(vals[2], vals[3]);

            intervals[i] = new Interval2D(x, y);
            intervals[i].draw();
        }
    }
}

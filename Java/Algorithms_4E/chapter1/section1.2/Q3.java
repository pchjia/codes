public class Q3 {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] intervals = new Interval2D[N];

        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.setPenRadius(0.002);

        for (int i=0; i<N; i++) {
            double[] vals = new double[4];
            // x and y
            vals[0] = StdRandom.uniform(-1.0, 1.0);
            vals[1] = StdRandom.uniform(-1.0, 1.0);
            // x -> width and y -> height
            vals[2] = StdRandom.uniform(min, max);
            vals[3] = StdRandom.uniform(min, max);

            if ((vals[0] + vals[2] >= -1.0) &&
                    (vals[0] + vals[2] <= 1.0) && 
                    (vals[1] + vals[3] >= -1.0) &&
                    (vals[1] + vals[3] <= 1.0)) {
                Interval1D x = new Interval1D(vals[0], vals[0] + vals[2]);
                Interval1D y = new Interval1D(vals[1], vals[1] + vals[3] );

                intervals[i] = new Interval2D(x, y);
                intervals[i].draw();
            } else {
                i--;
            }
        }
    }
}

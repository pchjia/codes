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

        Counter inters = new Counter("inters");
        Counter contains = new Counter("contains");
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (intervals[i].intersect(intervals[j])) {
                    inters.increment();
                }

                if ((intervals[i].x().lo() <= intervals[j].x().lo()) && 
                        (intervals[i].x().hi() >= intervals[j].x().hi()) &&
                        (intervals[i].y().lo() <= intervals[j].y().lo()) &&
                        (intervals[i].y().hi() >= intervals[j].y().hi())) {
                    contains.increment();        
                }

                if ((intervals[j].x().lo() <= intervals[i].x().lo()) && 
                        (intervals[j].x().hi() >= intervals[i].x().hi()) &&
                        (intervals[j].y().lo() <= intervals[i].y().lo()) &&
                        (intervals[j].y().hi() >= intervals[i].y().hi())) {
                    contains.increment();        
                }
            }
        }

        System.out.println(inters);
        System.out.println(contains);
    }
}

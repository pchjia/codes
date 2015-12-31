public class Q1 {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];

        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.setPenRadius(0.005);

        double min = 2.0;
        for (int i=0; i<N; i++) {
            points[i] = new Point2D(StdRandom.uniform(-1.0, 1.0), StdRandom.uniform(-1.0, 1.0));
            points[i].draw();
            for (int j=0; j<i; j++) {
                double xth = points[i].x() - points[j].x();
                double yth = points[i].y() - points[j].y();
                double dist = xth*xth + yth*yth;
                if (dist < min) {
                    min = dist;
                }
            }
        }

        min = Math.sqrt(min);
        System.out.println(min);
    }
}

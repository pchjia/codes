public class Q1 {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];

        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.setPenRadius(0.005);

        for (int i=0; i<N; i++) {
            points[i] = new Point2D(StdRandom.uniform(-1.0, 1.0), StdRandom.uniform(-1.0, 1.0));
            points[i].draw();
        }
    }
}

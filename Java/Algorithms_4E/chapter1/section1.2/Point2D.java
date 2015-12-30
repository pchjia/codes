public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double theta() {
        return Math.sqrt(x()*x() + y()*y());
    }

    public double distTo(Point2D that) {
        double xth = this.x - that.x;
        double yth = this.y - that.y;
        return Math.sqrt(xth*xth + yth*yth);
    }

    public void draw() {
        StdDraw.setXscale(-2*Math.abs(x), 2*Math.abs(x));
        StdDraw.setYscale(-2*Math.abs(y), 2*Math.abs(y));
        StdDraw.setPenRadius(.005);

        StdDraw.point(x(), y());
    }
}

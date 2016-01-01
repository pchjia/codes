public class Interval2D {
    private Interval1D x;
    private Interval1D y;

    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
    }

    public Interval1D x() {
        return new Interval1D(x.lo(), x.hi());
    }

    public Interval1D y() {
        return new Interval1D(y.lo(), y.hi());
    }

    public double area() {
        return x.length() * y.length();
    }

    public boolean contains(Point2D p) {
        if (!x.contains(p.x()) || !y.contains(p.y())) {
            return false;
        }

        return true;
    }

    public boolean intersect(Interval2D that) {
        if (!this.x.intersect(that.x) || !this.y.intersect(that.y)) {
            return false;
        }

        return true;
    }

    public void draw() {
        double[] xs = {x.lo(), x.lo(), x.hi(), x.hi()};
        double[] ys = {y.lo(), y.hi(), y.hi(), y.lo()};
        StdDraw.polygon(xs, ys);
    }
}

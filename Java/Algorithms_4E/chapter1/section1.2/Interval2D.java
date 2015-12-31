public class Interval2D {
    private Interval1D x;
    private Interval1D y;

    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
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
        double[] ys = {y.lo(), y.lo()+y.length(), y.hi(), y.hi()+y.length()};
        StdDraw.polygon(xs, ys);
    }
}

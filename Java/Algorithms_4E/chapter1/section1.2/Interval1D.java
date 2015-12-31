public class Interval1D {
    private double lo;
    private double hi;

    public Interval1D(double lo, double hi) {
        this.lo = lo;
        this.hi = hi;
    }
    
    public double length() {
        return hi - lo;
    }

    public boolean contains(double x) {
        if (x < lo || x > hi) {
            return false;
        }

        return true;
    }

    public boolean intersect(Interval1D that) {
        if (this.lo > that.hi || that.lo > this.hi) {
            return false;
        }

        return true;
    }

    public void draw() {
        StdDraw.line(0.0, lo, 0.0, hi);
    }

    public String toString() {
        return "[" + lo + ", " + hi + "];";
    }
}

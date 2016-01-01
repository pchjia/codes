public class Q10 {
    public static void main (String[] args) {
        VisualCounter count = new VisualCounter(100, 100);
        for (int i=0; i<100; i++) {
            count.increment();
            if (i%10 == 0) {
                count.decrement();
            }
        }
    }
}

class VisualCounter {
    private int count;
    private int N;
    private int max;
    private int times;

    public VisualCounter(int N, int max) {
        count = 0;
        times = 0;
        this.N = N;
        this.max = max;

        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void increment() {
        if (count > max || times > N) {
            return;
        }
        count ++;
        times ++;
        StdDraw.point(times, count);
    }

    public void decrement() {
        if (count > max || times > N) {
            return;
        }
        count --;
        times ++;
        StdDraw.point(times, count);
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return tally() + " " + N + " " + max;
    }
}

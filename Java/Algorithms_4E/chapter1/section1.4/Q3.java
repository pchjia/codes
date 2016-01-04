public class Q3 {
    public static void main (String[] args) {
        int MAX = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, MAX);
        StdDraw.setYscale(-3, 5);
        StdDraw.setPenRadius(0.005);
        for (int N=1; N<MAX; N+=10) {
            double time = DoublingTest.timeTrial(N);
            double logTime = Math.log(1.0 * time);
            StdDraw.point(N, time);
            StdDraw.point(N, logTime);
            StdOut.printf("%7d %5.1f\n", N, time);
            StdOut.printf("%7d %5.1f\n", N, logTime);
        }
    }
}

class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i=0; i<N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
}

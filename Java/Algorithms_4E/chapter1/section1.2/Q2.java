public class Q2 {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] intervals = new Interval1D[N];
        
        for (int i=0; i<N; i++) {
            intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
            for (int j=0; j<i; j++) {
                if (intervals[i].intersect(intervals[j])) {
                    System.out.println(intervals[i] + " " + intervals[j]);
                }
            }
        }
    }
}

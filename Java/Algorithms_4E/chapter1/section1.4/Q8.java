import java.util.Arrays;

public class Q8 {
    public static void main (String[] args) {
        In in = new In(args[0]);
        int[] a = in.readInts();
        int cnt = 0;
        Arrays.sort(a);
        for (int i=0; i<a.length; i++) {
            if (BinarySearch.rank(a[i], a) != -1) {
                cnt ++;
            }
        }
    }
}

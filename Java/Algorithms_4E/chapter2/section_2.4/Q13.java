public class Q13 {
    public static void sink(Comparable[] a, int i, int N) {
        while (2*i < N) {
            int j = 2*i;
            if (less(a[j-1], a[j])) {
                j ++;
            }
            if (!less(a[i-1], a[j-1])) {
                break;
            }
            exch(a, i, j);
            i = j;
        }
    }
}

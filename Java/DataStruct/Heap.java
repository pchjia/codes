public class Heap {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k=N/2; k>=1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    public static void sink(Comparable[] a, int i, int N) {
        while (2*i <= N) {
            int j = 2*i;
            if (j < N && less(a[j-1], a[j])) {
                j ++;
            }
            if (!less(a[i-1], a[j-1])) {
                break;
            }
            exch(a, i, j);
            i = j;
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        i --;
        j --;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        String[] a = args;
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

import java.util.Random;

public class Quick3way {
    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void shuffle(Comparable[] a) {
        Random ran = new Random();
        int N = a.length;
        for (int i=0; i<N; i++) {
            exch(a, ran.nextInt(N), i);
        }
    }

    @SuppressWarnings("unchecked")
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo ) {
            return;
        }

        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
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

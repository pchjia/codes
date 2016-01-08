/*
 * sort(a, 7, 12, 11)  A A A A A A A B B B B B R D C 
 * sort(a, 0, 7, 6)    A A A A A A A B B B B B R D C 
 * sort(a, 14, 15, 14) A A A A A A A B B B B B D C R 
 * sort(a, 13, 14, 13) A A A A A A A B B B B B C D R
 */

public class Q12 {
    public static void main (String[] args) {
        Quick3way.sort(args);
    }
}

class Quick3way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

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
        System.out.printf("sort(a, %d, %d, %d)", lt, i, gt);
        show(a);
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

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
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

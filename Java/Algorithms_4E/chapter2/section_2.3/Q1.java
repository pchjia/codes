/*
 * exch(a, 1, 8)E A Y E S I O T U Q N S 
 * exch(a, 2, 3)E A E Y S I O T U Q N S 
 * exch(a, 3, 2)E A E Y S I O T U Q N S 
 * exch(a, 1, 1)A E E Y S I O T U Q N S 
 * exch(a, 11, 11)A E E S S I O T U Q N Y 
 * exch(a, 4, 10)A E E S N I O T U Q S Y 
 * exch(a, 7, 9)A E E S N I O Q U T S Y 
 * exch(a, 8, 7)A E E Q N I O S U T S Y 
 * exch(a, 6, 6)A E E O N I Q S U T S Y 
 * exch(a, 5, 5)A E E I N O Q S U T S Y 
 * exch(a, 4, 3)A E E I N O Q S U T S Y 
 * exch(a, 10, 10)A E E I N O Q S S T U Y 
 * exch(a, 9, 8)A E E I N O Q S S T U Y
 */

public class Q1 {
    public static void main (String[] args) {
        Quick.sort(args);
    }
}

class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo ) {
            return;
        }
        int j = partion(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);

    }

    public static int partion(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(a, i, j);
            System.out.printf("exch(a, %d, %d)", i, j);
            show(a);
        }
        exch(a, lo, j);
        System.out.printf("exch(a, %d, %d)", i, j);
        show(a);
        return j;
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

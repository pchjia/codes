/*
 * 0   , 8   , 11   E N E A I O S Q S Y U T 
 * 0   , 2   , 7    E A E N I O S Q S Y U T 
 * 0   , 1   , 1    A E E N I O S Q S Y U T 
 * 3   , 4   , 7    A E E I N O S Q S Y U T 
 * 5   , 5   , 7    A E E I N O S Q S Y U T 
 * 6   , 7   , 7    A E E I N O Q S S Y U T 
 * 9   , 11  , 11   A E E I N O Q S S T U Y 
 * 9   , 9   , 10   A E E I N O Q S S T U Y 
 */

public class Q2 {
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
        System.out.printf("%-4d, %-4d, %-4d ", lo, j, hi);
        show(a);
        
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
       }
        exch(a, lo, j);
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

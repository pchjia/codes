/*
 * for N:
 *  max number of the array max exchange times:
 *      10 100 1000 10000  ...
 *      3   6  9    11     ... 
 */

public class Q3 {
    public static void main (String[] args) {
        int MAX = Integer.parseInt(args[0]);
        int max = 0;
        for (int N=1; N<=MAX; N++) {
            Double[] a = new Double[N];
            Double m = 0.0;
            for (int i=0; i<N; i++) {
                a[i] = StdRandom.uniform();
                if (a[i] > m) {
                    m = a[i];
                }
            }
            int tmp = Quick.sort(a, m);
            if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println(max);
    }
}

class Quick {
    public static int count;
    public static int sort(Comparable[] a, Double m) {
        count = 0;
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1, m);
        return count;
    }

    public static void sort(Comparable[] a, int lo, int hi, Double m) {
        if (hi <= lo ) {
            return;
        }
        int j = partion(a, lo, hi, m);
        sort(a, lo, j-1, m);
        sort(a, j+1, hi, m);
    }

    public static int partion(Comparable[] a, int lo, int hi, double m) {
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
            if (a[i].equals(m) || a[j].equals(m)) {
                count ++;
            }
            exch(a, i, j);
        }
        if (a[i].equals(m) || a[j].equals(m)) {
            count ++;
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

}

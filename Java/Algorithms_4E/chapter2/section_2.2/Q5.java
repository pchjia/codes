/*
 * merge(a, 0, 0, 1). a.size() is 2
 * merge(a, 0, 2, 4). a.size() is 5
 * merge(a, 0, 4, 9). a.size() is 10
 * merge(a, 10, 10, 11). a.size() is 2
 * merge(a, 13, 13, 14). a.size() is 2
 * merge(a, 10, 12, 14). a.size() is 5
 * merge(a, 18, 18, 19). a.size() is 2
 * merge(a, 15, 17, 19). a.size() is 5
 * merge(a, 10, 14, 19). a.size() is 10
 * merge(a, 0, 9, 19). a.size() is 20
 * merge(a, 20, 21, 22). a.size() is 3
 * merge(a, 20, 22, 24). a.size() is 5
 * merge(a, 25, 26, 27). a.size() is 3
 * merge(a, 28, 28, 29). a.size() is 2
 * merge(a, 25, 27, 29). a.size() is 5
 * merge(a, 20, 24, 29). a.size() is 10
 * merge(a, 33, 33, 34). a.size() is 2
 * merge(a, 30, 32, 34). a.size() is 5
 * merge(a, 35, 35, 36). a.size() is 2
 * merge(a, 35, 36, 38). a.size() is 4
 * merge(a, 30, 34, 38). a.size() is 9
 * merge(a, 20, 29, 38). a.size() is 19
 * merge(a, 0, 19, 38). a.size() is 39
 *
 * merge(a, 0, 0, 1). a.size() is 2
 * merge(a, 2, 2, 3). a.size() is 2
 * merge(a, 4, 4, 5). a.size() is 2
 * merge(a, 6, 6, 7). a.size() is 2
 * merge(a, 8, 8, 9). a.size() is 2
 * merge(a, 10, 10, 11). a.size() is 2
 * merge(a, 12, 12, 13). a.size() is 2
 * merge(a, 14, 14, 15). a.size() is 2
 * merge(a, 16, 16, 17). a.size() is 2
 * merge(a, 18, 18, 19). a.size() is 2
 * merge(a, 20, 20, 21). a.size() is 2
 * merge(a, 22, 22, 23). a.size() is 2
 * merge(a, 24, 24, 25). a.size() is 2
 * merge(a, 26, 26, 27). a.size() is 2
 * merge(a, 28, 28, 29). a.size() is 2
 * merge(a, 30, 30, 31). a.size() is 2
 * merge(a, 32, 32, 33). a.size() is 2
 * merge(a, 34, 34, 35). a.size() is 2
 * merge(a, 36, 36, 37). a.size() is 2
 * merge(a, 0, 1, 3). a.size() is 4
 * merge(a, 4, 5, 7). a.size() is 4
 * merge(a, 8, 9, 11). a.size() is 4
 * merge(a, 12, 13, 15). a.size() is 4
 * merge(a, 16, 17, 19). a.size() is 4
 * merge(a, 20, 21, 23). a.size() is 4
 * merge(a, 24, 25, 27). a.size() is 4
 * merge(a, 28, 29, 31). a.size() is 4
 * merge(a, 32, 33, 35). a.size() is 4
 * merge(a, 36, 37, 38). a.size() is 3
 * merge(a, 0, 3, 7). a.size() is 8
 * merge(a, 8, 11, 15). a.size() is 8
 * merge(a, 16, 19, 23). a.size() is 8
 * merge(a, 24, 27, 31). a.size() is 8
 * merge(a, 32, 35, 38). a.size() is 7
 * merge(a, 0, 7, 15). a.size() is 16
 * merge(a, 16, 23, 31). a.size() is 16
 * merge(a, 0, 15, 31). a.size() is 32
 * merge(a, 0, 31, 38). a.size() is 39
 */

import java.util.Random;

public class Q5 {
    public static void main (String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i=0; i<N; i++) {
            a[i] = new Random().nextDouble();
        }

        StdRandom.shuffle(a);
        Merge.sort(a);
        Merge.show(a);

        System.out.println();

        StdRandom.shuffle(a);
        MergeBU.sort(a);
        MergeBU.show(a);
    }
}

abstract class Example {
    protected static Comparable[] aux;
    public static void sort(Comparable[] a){}

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }

        for (int k=lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
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

class Merge extends Example {
	public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        if (less(a[mid], a[mid+1]) || a[mid].equals(a[mid+1])) {
            return;
        }
        merge(a, lo, mid, hi);
        System.out.printf("merge(a, %d, %d, %d). a.size() is %d\n", lo, mid, hi, hi-lo+1);
    }

}

class MergeBU extends Example {
	public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz<N; sz = sz + sz) {
            for (int lo=0; lo<N-sz; lo += sz + sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
                System.out.printf("merge(a, %d, %d, %d). a.size() is %d\n", lo,
                        lo+sz-1, Math.min(lo+sz+sz-1, N-1), Math.min(lo+sz+sz-1, N-1)-lo+1);
            }
        }
    }
}

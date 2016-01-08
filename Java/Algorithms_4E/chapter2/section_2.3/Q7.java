/*
 * size of subarray for N is less than N
 */

public class Q7 {
    public static void main (String[] args) {
        Quick.sort(args);
        int[] a = Quick.count();
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            System.out.println("length:" + args.length + " size " + i + " counts " + a[i]);
            sum += a[i];
        }
        System.out.println(sum);
    }
}

class Quick {
    private static int[] count;
    public static void sort(Comparable[] a) {
        count = new int[3];
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    public static int[] count() {
        return count;
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        switch (hi-lo+1) {
            case 0:
                count[0] ++;
                break;
            case 1:
                count[1] ++;
                break;
            case 2:
                count[2] ++;
            default:
                break;
        }
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

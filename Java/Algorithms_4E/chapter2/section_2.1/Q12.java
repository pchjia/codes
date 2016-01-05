/*
 * 1.0
 * 3.6
 * 11.71
 * 22.298
 * 41.7474
 * 66.03455
 * 110.850114
 * 193.4258295
 */

public class Q12 {
    public static void main (String[] args) {
        Double[] a;
        for (int i=1; true; i*=10) {
            a = new Double[i];
            for (int j=0; j<i; j++) {
                a[j] = StdRandom.uniform();
            }
            Shell.sort(a);
        }
    }
}

class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        int count = 0;
        while (h < N/3) {
            count ++;
            h = 3*h + 1;
        }

        while (h >= 1) {
            count ++;
            for (int i=h; i<N; i++) {
                count ++;
                for (int j=i; j>=h && less(a[j], a[j-h]); j-=h) {
                    count +=2;
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }

        System.out.println((double)count/(double)N);
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

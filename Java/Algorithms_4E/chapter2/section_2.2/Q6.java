import java.util.Random;

public class Q6 {
    public static void main (String[] args) {
        int MAX = Integer.parseInt(args[0]);
        int[] a1 = new int[MAX];
        int[] a2 = new int[MAX];
        for (int N=1; N<=MAX; N++) {
            Double[] a = new Double[N];
            for (int i=0; i<N; i++) {
                a[i] = new Random().nextDouble();
            }

            StdRandom.shuffle(a);
            a1[N-1] = Merge.sort(a);

            StdRandom.shuffle(a);
            a2[N-1] = MergeBU.sort(a);
        }
        StdDraw.setXscale(0, MAX);
        StdDraw.setYscale(0, 1.2 * Math.max(a1[MAX-1], a2[MAX-1]));
        StdDraw.setPenRadius(0.005);
        for (int i=0; i<MAX; i++) {
            // Merge
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(i+1, a1[i]);
            // MergeBU
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(i+1, a2[i]);
            // 6 * N * lg(N)
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i+1, 6* (i+1) * Math.log(i+1));
        }
    }
}

abstract class Example {
    protected static Comparable[] aux;
    protected static int count;
    public static int sort(Comparable[] a){ return -1;}

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k=lo; k<=hi; k++) {
            aux[k] = a[k];
            count ++;
        }

        for (int k=lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
                count ++;
            } else if (j > hi) {
                a[k] = aux[i++];
                count ++;
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                count ++;
                count += 2;
            } else {
                a[k] = aux[i++];
                count ++;
                count += 2;
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
        count += 4;
    }

    public static void show(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(count() + " times access array");
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static int count() {
        return count;
    }

}

class Merge extends Example {
	public static int sort(Comparable[] a) {
        count = 0;
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
        return count();
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        count += 2;
        if (less(a[mid], a[mid+1]) || a[mid].equals(a[mid+1])) {
            return;
        }
        merge(a, lo, mid, hi);
    }

}

class MergeBU extends Example {
	public static int sort(Comparable[] a) {
        count = 0;
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz<N; sz = sz + sz) {
            for (int lo=0; lo<N-sz; lo += sz + sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
        return count();
    }
}

public class Q9 {}

class Merge {
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length-1, aux);
    }

    public static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, aux);
        sort(a, mid+1, hi, aux);
        if (less(a[mid], a[mid+1]) || a[mid].equals(a[mid+1])) {
            return;
        }
        merge(a, lo, mid, hi, aux);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
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

    public static void main (String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

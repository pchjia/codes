public class Q11{
    public static void main (String[] args) {
        String[] a = args;
        Shell.sort(a);
        Shell.show(a);
    }
}

class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int count = 1;
        int tmp = 1;

        while (tmp < N) {
            tmp = tmp*3 + 1;
            count ++;
        }

        Integer[] n = new Integer[count];
        n[0] = 1;
        for (int i=1; i<n.length; i++) {
            n[i] = n[i-1] * 3 + 1;
        }

        for (int t=n.length-1; t>=0; t--) {
            int h = n[t];
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
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

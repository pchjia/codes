public class Q6 {
    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo=0;
        int hi = a.length-1;
        return select(a, k, lo, hi);
    }
    private static Comparable  select(Comparable[] a, int k, int lo, int hi) {
        int j = partion(a, lo, hi);
        if (j == k) {
            return a[j];
        } else if (j > k) {
            return select(a, k, lo, j-1);
        } else if (j < k) {
            return select(a, k, j+1, hi);
        }
    }

    private static int partion(Comparable[] a, int lo, int hi) {
        if (lo <= hi) {
            return lo;
        }

        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (a[++i].compareTo(v) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j].compareTo(v) >= 0) {
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
    private static void exch(Comparable[] a, int i, int j) {
         Comparable tmp = a[i];
         a[i] = a[j];
         a[j] = tmp;
    }
}

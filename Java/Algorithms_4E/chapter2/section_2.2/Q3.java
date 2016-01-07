/*
      Mrege(a, 0, 0, 1)     A E S Y Q U E S T I O N 
      Mrege(a, 2, 2, 3)     A E S Y Q U E S T I O N 
      Mrege(a, 4, 4, 5)     A E S Y Q U E S T I O N 
      Mrege(a, 6, 6, 7)     A E S Y Q U E S T I O N 
      Mrege(a, 8, 8, 9)     A E S Y Q U E S I T O N 
      Mrege(a, 10, 10, 11)  A E S Y Q U E S I T N O 
     Mrege(a, 0, 1, 3)      A E S Y Q U E S I T N O 
     Mrege(a, 4, 5, 7)      A E S Y E Q S U I T N O 
     Mrege(a, 8, 9, 11)     A E S Y E Q S U I N O T 
   Mrege(a, 0, 3, 7)        A E E Q S S U Y I N O T 
Mrege(a, 0, 7, 11)   A E E I N O Q S S T U Y 
*/

public class Q3 {
    public static void main (String[] args) {
        MergeBU.sort(args);
    }
}

class MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz<N; sz = sz + sz) {
            for (int lo=0; lo<N-sz; lo += sz + sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
                int len = sz;
                for (int i=0; i<a.length-len-1; i++) {
                    System.out.print(" ");
                }
                System.out.printf("Mrege(a, %d, %d, %d)\t", lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
                show(a);
          }
        }
    }

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

    public static void main (String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

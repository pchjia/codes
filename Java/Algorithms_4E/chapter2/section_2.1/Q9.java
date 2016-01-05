/*
 * input:   E A S Y Q U E S T I O N
 * 4-sort   E A S Y Q U E S T I O N 
 *          E A S Y Q U E S T I O N 
 *          E A E Y Q U S S T I O N 
 *          E A E S Q U S Y T I O N 
 *          E A E S Q U S Y T I O N 
 *          E A E S Q I S Y T U O N 
 *          E A E S Q I O Y T U S N 
 *          E A E N Q I O S T U S Y 
 *
 * 1-sort   A E E N Q I O S T U S Y 
 *          A E E N Q I O S T U S Y 
 *          A E E N Q I O S T U S Y 
 *          A E E N Q I O S T U S Y 
 *          A E E I N Q O S T U S Y 
 *          A E E I N O Q S T U S Y 
 *          A E E I N O Q S T U S Y 
 *          A E E I N O Q S T U S Y 
 *          A E E I N O Q S T U S Y 
 *          A E E I N O Q S S T U Y 
 *          A E E I N O Q S S T U Y
 */

public class Q9 {
    public static void main (String[] args) {
        String[] a = args; // E A S Y Q U E S T I O N
        Shell.sort(a);
    }
}

class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }

        while (h >= 1) {
            System.out.print(h + "-sort ");
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
                show(a);
                System.out.print("       ");
            }
            h = h/3;
            System.out.println();
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

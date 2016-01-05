/*
 *           a[]
 * i min    0 1 2 3 4 5 6 7 8 9 10 11
 *          E A S Y Q U E S T I O N
 * 0  1     A E S Y Q U E S T I O N 
 * 1  1     A E S Y Q U E S T I O N 
 * 2  6     A E E Y Q U S S T I O N 
 * 3  9     A E E I Q U S S T Y O N 
 * 4  11    A E E I N U S S T Y O Q 
 * 5  10    A E E I N O S S T Y U Q 
 * 6  11    A E E I N O Q S T Y U S 
 * 7  7     A E E I N O Q S T Y U S 
 * 8  11    A E E I N O Q S S Y U T 
 * 9  11    A E E I N O Q S S T U Y 
 * 10 10    A E E I N O Q S S T U Y 
 * 11 11    A E E I N O Q S S T U Y 
 */

public class Q1 {
    public static void main (String[] args) {
        String[] a = args; // E A S Y Q U E S T I O N
        Selection.sort(a);
    }
}

class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i=0; i<N; i++) {
            int min = i;
            for (int j=i+1; j<N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            System.out.print(i + " " + min + " ");
            show(a);
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

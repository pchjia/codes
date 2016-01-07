/*
 * =>:
 *      ordered -> merge -> correct result
 * <=:
 *      merge() -> correct result:
 *          suppose: the array is disordered
 *          then merge(the array) -> false result
 *          therefore, the array is ordered
 */

public class Q4 {
    private static Comparable[] aux;
    public static void main (String[] args) {
    
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
}

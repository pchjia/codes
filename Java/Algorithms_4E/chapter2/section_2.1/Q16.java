public class Q16 {
    public static boolean check(Comparable[] a) {
        int len = a.length();
        boolean res = true;
        Comparable[] b = new Comparable[len];
        for (int i=0; i<len; i++) {
            b[i] = a[i];
        }
        sort(b);
        for (int i=0; i<len; i++) {
            if (!b[i].equals(a[i])) {
                res = false;
                break;
            }
        }
        return res;
    }
}
public class Q5 {
    public static void main (String[] args) {
        String[] a = args;
        Selection.sort(a);
        String[] res = new String[a.length];
        for (int i=0; i<a.length; i++) {
            res[i] = a[i];
        }
    }
}

public class Q3 {
    public static void main (String[] args) {
        String[] a = args;
        int N = a.length;
        Selection.sort(a);
        String[] res = new String[N];
        for (int i=0; i<N; i++) {
            res[i] = a[N-1-i];
        }
    }
}

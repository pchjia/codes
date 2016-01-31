public class Q4 {
    public static String[] dedup(String[] a) {
        int len = a.length;
        String[] tmp = new String[len];
        for (int i=0; i<len; i++) {
            tmp[i] = a[i];
        }

        Quick.sort(tmp);

        int N = len;
        for (int i=0; i<N-1; i++) {
            if (tmp[i].compareTo(tmp[i+1]) == 0) {
                delete(tmp, i--, N);
                N--;
            }
        }

        String[] res = new String[N];
        for (int i=0; i<N; i++) {
            res[i] = tmp[i];
        }

        return res;
    }

    private static void delete(String[] a, int k, int len) {
        for (int i=k; i<len; i++) {
            a[i] = a[i] + 1;
        }
    }
}

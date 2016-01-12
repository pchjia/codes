public class Q15 {
    public static void main (String[] args) {
        
    }

    public static <Key extends Comparable<Key>> boolean isMaxOriented(Key[] pq) {
        boolean flag = true;
        int N = pq.length;
        int k = 1;
        while (2*k<=N) {
            int i = 2 * k;
            int j = 2 * k + 1;
            if (pq[k].compareTo(pq[i]) < 0 || pq[k].compareTo(pq[j]) < 0) {
                flag = false;
            }
            k = k++;
        }
        return flag;
    }
}

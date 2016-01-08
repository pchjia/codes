public class Q5 {
    public static void main (String[] args) {
        String[] a = args;
        int N = a.length;
        int lt = 0;
        int i = 0;
        int gt = N - 1;
        Comparable v = a[0];
        while (i <= gt) {
            int cmp = v.compareTo(a[i]);
            if (cmp > 0) {
                exch(a, i++, lt++);
            } else if (cmp < 0) {
                exch(a, i, gt--);
            } else {
                i ++;
            }
        }
        for (String s: a) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
